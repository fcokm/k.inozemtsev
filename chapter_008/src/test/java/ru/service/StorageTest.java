package ru.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import ru.configuration.AppConfig;
import ru.configuration.SpringJdbcConfig;
import ru.domain.User;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, SpringJdbcConfig.class})
public class StorageTest {

    @Autowired
    ImportUser importUser;

    @Before
    public void setUp() throws Exception {
        importUser.add(new User("KEVIN"));
        importUser.add(new User("DENNIS"));
        importUser.add(new User("MIKE"));
    }

    @Test
    public void whenGetAllUsersThenContainAllUsers() {
        assertThat(importUser.all(), hasItems(
                new  User(1,"KEVIN"),
                new User(2,"DENNIS"),
                new User(3,"MIKE")

        ));
    }

    @Test
    public void whenUpdateNameUserByIdThenUFindUserById() {
       importUser.update(new User(2, "JACK"));
        assertThat("JACK", is(
          importUser.findById(2).getName()
        ));
    }


    @Test
    public void whenDeleleUserByIdThenFindByIdResultNull() {
        importUser.delete(1);
        assertNull(importUser.findById(1));
    }


}
