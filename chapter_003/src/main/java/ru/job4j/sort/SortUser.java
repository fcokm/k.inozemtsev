package ru.job4j.sort;

import java.util.*;


/**
 * Class SortUser
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortUser {

    /**
     * Метод оторый будет возвращает пользователей, отсортированных
     * отсортированных по возрасту в порядке возрастания.
     *
     * @return set
     */
    public Set<User> sort(List<User> list) {
        Set<User> set = new TreeSet<>(list);
        return set;
    }

    public List<User> sortNameLength(List<User> list) {
        List<User> listUsers = new ArrayList<>(list);
        Collections.sort(listUsers, User.UserLengthNameComparator);
        return listUsers;
    }


    public List<User> sortByAllFields(List<User> list) {
        List<User> listUsers = new ArrayList<>(list);
        Collections.sort(listUsers, User.UserComparator);
        return listUsers;
    }


    public static void main(String[] args) {
        List<User> list = new ArrayList<User>(Arrays.asList(new User("Mike11", 23),
                new User("Jack1", 35), new User("Nic", 18)));
        List<User> list1 = new ArrayList<>(Arrays.asList(new User("Сергей", 25), new User("Иван", 30),
                new User("Сергей", 20), new User("Иван", 25)));
     //  List<User> set = new SortUser().sortNameLength(list);
        for(User user : list1)
        System.out.println(user.getName()+"  "+user.getAge());
        System.out.println("************************");
        List<User> set1 = new SortUser().sortByAllFields(list1);
        for(User user : set1)
            System.out.println(user.getName()+"  "+user.getAge());

    }
}
