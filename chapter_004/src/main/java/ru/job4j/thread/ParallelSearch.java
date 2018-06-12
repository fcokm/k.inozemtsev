package ru.job4j.thread;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.concurrent.*;


/**
 *  Class ParallelSearch реализует поиск текста в файле.
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class ParallelSearch {
    /**
     * Путь до папки откуда надо осуществлять поиск
     */
    private final String root;
    /**
     * Текст поиска в файле
     */
    private final String text;
    /**
     * Список расширений файлов в которых осуществляется делать поиск.
     */
    private final List<String> exts;
    /**
     * Шаблон  расширений файлов
     */
    private final String TEMPLATE = "glob:*";
    /**
     * Флаг проверки завершения работы нити seach
     */
    volatile boolean finish = false;


    /**
     * Очередь для хранения адресов с файлами
     */
    @GuardedBy("this")
    private final Queue<String> files = new LinkedBlockingQueue<>();
    /**
     * Список для хранения адресов с файлами с найденным текстом
     */
    @GuardedBy("this")
    private final List<String> paths = new ArrayList<>();


    /**
     * Конструктор - создание нового объекта с параметрами
     * @param root - путь до папки откуда надо осуществляется  поиск.
     * @param text - текст поиска
     * @param exts - список расширений файлов в которых осуществляется поиск.
     *
     */
    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }


    /**
     * Метод запускает нити поиска
     */
    public void init() {
        Thread search = new Thread() {
            @Override
            public void run() {
                call();
            }
        };

        Thread read = new Thread(new Runnable() {
            @Override
            public void run() {
                search();
            }
        });

        search.start();
        read.start();

        try {
            read.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    /**
     * Метод выполняет поиск файлов по
     * заданным расширениям
     */
    public void call() {
        Path fileDir = Paths.get(this.root);
        try {
        for (String e : exts) {
                Files.walkFileTree(fileDir, new FileVisitor(TEMPLATE.concat(e)));
        }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            this.finish = true;
        }
    }


    /**
     * Метод выполняет ипоиск текст в файлах
     * и сохраняет адрес файла.
     */
    public void search() {
        File file;
        synchronized (this.files) {
            while (!finish) {
                while (!files.isEmpty()) {
                    try {
                        file = new File(this.files.poll());
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                new FileInputStream(file)));
                        String line;
                        while ((line = br.readLine()) != null) {
                            if (line.contains(this.text)) {
                                this.paths.add(file.toString());
                                break;
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
       }
    }


    /**
     * Метод возвращает список адресов файлов
     * @return paths
     */
    synchronized public List<String> result() {
        return this.paths;
    }



    /**
     *  Class FileVisitor
     */
    private class FileVisitor extends SimpleFileVisitor<Path> {
        /**
         * Поле интерфейса PathMatcher
         */
        private PathMatcher matcher;

        /**
         * Конструктор - создание нового объекта с параметрами
         * @param pattern - строка шаблона расширения файла
         *
         */
        public FileVisitor(String pattern) {
            this.matcher = FileSystems.getDefault().getPathMatcher(pattern);
        }

        /**
         * Метод добавляет адрес файла по найденному расширению
         * @param path адрес файла
         */
        private void find(Path path) {
            Path name = path.getFileName();
            if (matcher.matches(name)) {
                files.offer(path.toString());
            }
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
           find(dir);
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

            find(file);
            return FileVisitResult.CONTINUE;
        }
        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            System.err.println(exc.getMessage());
            return FileVisitResult.CONTINUE;
        }

    }

}
