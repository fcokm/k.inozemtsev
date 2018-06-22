package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PhoneDictionary реализует поиск в
 * телефонном справочнике
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PhoneDictionary {
    /**
     * Список пользователя добавленых в справочнике.
     */
    private List<Person> persons = new ArrayList<Person>();

    /**
     * Метод добавляет пользователя в справочник
     * @param person - клиент
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод возвращает список всех пользователей по ключу.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(key) || person.getAddress().contains(key) ||
                    person.getPhone().contains(key) || person.getSurname().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}