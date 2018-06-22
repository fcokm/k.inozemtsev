package ru.sort;

import org.junit.Test;
import ru.job4j.sort.User;
import ru.job4j.sort.SortUser;
import java.util.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenUsersSortedByAgeInAscendingOrder() {
        SortUser sortUser = new SortUser();
        User firstUser = new User("Mike", 23);
        User secondUser = new User("Jack", 35);
        User thirdUser = new User("Nick", 18);
        List<User> list = new ArrayList<>(Arrays.asList(firstUser, secondUser, thirdUser));
        Set<User> set = sortUser.sort(list);
        assertThat(set, contains(thirdUser,  firstUser, secondUser));

    }

}
