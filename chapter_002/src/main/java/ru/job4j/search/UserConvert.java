package ru.job4j.search;

import java.util.HashMap;
import java.util.Map;
import java.util.List;


 public class UserConvert {

     HashMap<Integer, User> process(List<User> list) {
         HashMap<Integer, User> map = new HashMap<Integer, User>();
         for(User user : list) {
            map.put(user.getId(), user);
         }
         return map;
     }
}
