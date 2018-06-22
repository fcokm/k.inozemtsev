package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

 public class UserConvertTest {

     @Test
     public void whenHigherPriority() {
         UserConvert convert = new UserConvert();
         HashMap<Integer, User> userMap =new  HashMap<Integer, User>();
         User firstUser = new User(1, "Andrei", "Moscow");
         User secondUser = new User(2, "Fedor", "Omsk");
         User thirdUser = new User(3, "Maksim", "Sochi");
         List<User> userList = new ArrayList<>(Arrays.asList(firstUser, secondUser, thirdUser));
         userMap = convert.process(userList);
         User user = userMap.get(2);
         assertThat(user.getName(), is("Fedor"));
     }
}
