package ru.job4j.search;

import java.util.LinkedList;

/**
 * Class PriorityQueue  класс реализует очередь с приоритетом
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PriorityQueue {
    /**
     * Список задач.
     */
    private LinkedList<Task> tasks = new LinkedList<>();
    /**
     * Приоритет задачи.
     */
    int  priority = 0;

    /**
     * Метод добавляет задачу в список по полю приоритет.
     * @param task задача.
     */
    public void put(Task task) {
        if (!tasks.isEmpty()) {
            for (Task t : tasks) {
                if ( t.getPriority() > task.getPriority()) {
                    tasks.add(tasks.indexOf(t), task);
                    priority++;
                    break;
                }
            }
        }else {
            tasks.add(priority++, task);
        }
    }

    /**
     * Метод возвращает задачу с наивысшим приоритетом
     *
     * @return task задача.
     */
    public Task take() {
        return this.tasks.poll();
    }

}