package ru.job4j.search;

import java.util.*;


/**
 * Class UserConvert
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserConvert {

    /**
     * Метод  принимает  список пользователей и конвертирует его в Map
     * @param list - список пользователей
     * @return map карта .
     */
     HashMap<Integer, User> process(List<User> list) {
         HashMap<Integer, User> map = new HashMap<Integer, User>();
         for(User user : list) {
            map.put(user.getId(), user);
         }
         return map;
     }

}
