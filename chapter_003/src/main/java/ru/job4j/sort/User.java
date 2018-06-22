package ru.job4j.sort;


import java.util.Comparator;

/**
 * Class User
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class User implements Comparable<User> {
    /**
     * age пользователя.
     */
    private int age;

    /**
     * Имя пользователя.
     */
    private String name;


    /**
     * Конструктор - создание нового объекта с параметрами
     */
    public User()  {
    }

    /**
     * Конструктор - создание нового объекта с параметрами
     * @param name - имя пользователя
     * @param age - возраст пользователя
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    /**
     * Метод для получения значения поля name
     * @return name имя
     */
    public String getName() {
        return name;
    }

    /**
     * Метод для получения значения поля age
     * @return age индификатор
     */
    public int getAge() {
        return age;
    }

    /**
     * Метод  сравнивает объекты
     * @return 0 если объекты равны,
     * 1 если текущий объект больше,
     * в противном случаи -1.
     */
    @Override
    public int compareTo(User user) {
        return this.age - user.getAge();
    }


    public static Comparator<User> UserLengthNameComparator  = new Comparator<User>() {
        @Override
        public int compare(User user1, User user2) {
            Integer lengthNameUser1 = user1.getName().length();
            Integer lengthNameUser2 = user2.getName().length();
            return lengthNameUser1.compareTo(lengthNameUser2);
        }
    };

    public static Comparator<User> UserComparator = new Comparator<User>() {
        @Override
        public int compare(User user1, User user2) {
            String userName1 = user1.getName().toUpperCase();
            String userName2 = user2.getName().toUpperCase();
            int  compareName = userName1.compareTo(userName2);
            int  compareAge = new Integer(user1.getAge()).compareTo(user2.getAge());
            return compareName == 0 ? compareAge  : compareName;
        }
    };

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
