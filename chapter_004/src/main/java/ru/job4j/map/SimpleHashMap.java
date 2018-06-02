package ru.job4j.map;


import ru.job4j.list.SimpleList;

import java.util.*;

/**
 * Class SimpleHashMap
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SimpleHashMap<K, V> {
    /**
     * Массив хеш-таблицы
     */
    private Node<K, V>[] hashTable;
    /**
     * Размер таблицы
     */
    private int size;

    public int getSize() {
        return size;
    }

    /**
     * Константа коэфициента загрузки хеш-таблицы
     */
    private static final float LOADFACTOR = 0.75F;

    /**
     * Порог загруженности хеш-таблицы
     */
    private float threshold;

    /**
     * Счетчик изменений списка
     */
    private int modCount;

    /**
     * Конструктор - создание нового объекта
     */
    public SimpleHashMap() {
        hashTable = new Node[16];
        threshold = hashTable.length * LOADFACTOR;
    }


    /**
     * Метод добавляет ключ и значения в хеш-таблицу
     *
     * @param key   ключ хеш-таблицы
     * @param value значение  хеш-таблицы
     * @return true если таблица не содержит элемент e,
     * в противном случае false.
     */
    public boolean insert(K key, V value) {
        boolean flag = false;
        if (size + 1 >= threshold) {
            threshold *= 2;
            resize(hashTable.length * 2);
        }
        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);
        if ((index < Integer.MAX_VALUE & index > Integer.MIN_VALUE) & hashTable[index] == null) {
            hashTable[index] = newNode;
            size++;
            modCount++;
            flag = true;
        }
        return flag;
    }


    /**
     * Метод проверяет , содержит ли  хеш-таблица ключ key
     *
     * @param key ключ
     * @return true если содержит, false нет.
     */
    public boolean contains(K key) {
        boolean flag = false;
        int index = hash(key);
        if (index < hashTable.length && hashTable[index] != null && hashTable[index].key.equals(key)) {
            flag = true;
        }
        return flag;
    }

    /**
     * Метод удаляет из  хеш-таблицы элемент по ключу
     *
     * @param key ключ
     * @return true , если элемент удален false - нет.
     */
    public boolean delete(K key) {
        boolean flag = false;
        int index = hash(key);
        if (contains(key)) {
            hashTable[index] = null;
            size--;
            flag = true;
        }
        return flag;
    }


    /**
     * Метод возвращает значение по ключу элемента
     *
     * @param key ключ
     * @return value значение элемента
     */
    public V get(K key) {
        V value = null;
        int index = hash(key);
        if (index < hashTable.length && hashTable[index] != null && hashTable[index].key.equals(key)) {
            value = (V) hashTable[index].value;
        }
        return value;
    }

    /**
     * Метод увеличивает размер хеш-таблицы
     *
     * @param newLength размер
     */
    private void resize(int newLength) {
        Node<K, V>[] oldTabl = hashTable;
        hashTable = new Node[newLength];
        for (int i = 0; i < oldTabl.length; i++) {
            if (hashTable[i] != null) {
                insert(hashTable[i].key, hashTable[i].value);
            }
        }

    }

    /**
     * Метод возвращает хеш код по ключу
     *
     * @param key ключ
     * @return хеш код
     */
    private int hash(K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % hashTable.length;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private class Node<K, V> {
        private int hash;
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleHashMap<?, ?> that = (SimpleHashMap<?, ?>) o;
        return Arrays.equals(hashTable, that.hashTable);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(hashTable);
    }


    /**
     * Метод возвращает итератор
     * @return итератор.
     */
    public Iterator<V> iterator(){
        return new Iterator<V>() {
            private int index = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean flag = false;
                int pointer = index;
                while (pointer < hashTable.length) {
                    if (hashTable[pointer++] != null) {
                        flag = true;
                        index = pointer - 1;
                        break;
                    }
                }
                return flag;
            }

            @Override
            public V next() {
                if (hashTable.length == 0 || !hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return hashTable[index++].value;
            }
        };

    }

}



