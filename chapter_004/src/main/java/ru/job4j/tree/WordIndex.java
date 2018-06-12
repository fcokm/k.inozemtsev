package ru.job4j.tree;

import java.io.*;
import java.util.*;



/**
 *  Class WordIndex
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class WordIndex {
    /**
     * Список символов
     */
    private final List<Character> charsList = new ArrayList<>();
    /**
     * Префиксное дерево
     */
    private Trie trie = new Trie();


    /**
     * Метод  загружает данные из файла
     * @param filename имя файла
     */
    public void loadFile(String filename) {
        File file = new File(filename);
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file)));
            br.read();
            int c;
            while ((c = br.read()) != -1) {
                char ch = (char) c;
                charsList.add(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод  возвращает список позиций слова в файле.
     * @param searchWord слово поиска
     * @return set , если слово не найдено null.
     */
    public Set<Integer> getIndexes4Word(String searchWord) {
        List<Character> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        trie.add(searchWord);
        for (int i = 0; i < charsList.size(); i++) {
            if (charsList.get(i) != 32) {
                list.add((char) charsList.get(i));
            } else {
                if (trie.contains(list)) {
                    set.add(i - list.size());
                }
                list.clear();
            }
        }
        return set.isEmpty() ? null : set;
    }

    /**
     *  Class Trie
     */
    private class Trie {
        /**
         * Корень дерева
         */
        HashMap<Character, HashMap> root;

        /**
         * Конструктор - создание нового объекта
         */
        public Trie() {
            root = new HashMap<Character, HashMap>();
        }


        /**
         * Метод добавляет строку в дерево
         * @param s строка
         */
        public void add(String s) {
            HashMap<Character, HashMap> curr_node = root;
            for (int i = 0, n = s.length(); i < n; i++) {
                Character c = s.charAt(i);
                if (curr_node.containsKey(c))
                    curr_node = curr_node.get(c);
                else {
                    curr_node.put(c, new HashMap<Character, HashMap>());
                    curr_node = curr_node.get(c);
                }
            }
            curr_node.put('\0', new HashMap<Character, HashMap>(0));
        }



        /**
         * Метод проверяет , содержит дерево  список символов
         * @param cn список символов
         * @return true если содержит, false нет.
         */
        public boolean contains(List<Character> cn) {
            HashMap<Character, HashMap> curr_node = root;
            for (int i = 0, n = cn.size(); i < n; i++) {
                if (curr_node.containsKey(cn.get(i)))
                    curr_node = curr_node.get(cn.get(i));
                else
                    return false;
            }
            if (curr_node.containsKey('\0'))
                return true;
            else
                return false;
        }

    }
}

