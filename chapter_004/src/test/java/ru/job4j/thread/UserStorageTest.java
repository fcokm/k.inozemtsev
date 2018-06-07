package ru.job4j.thread;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;



public class UserStorageTest {
    User u1;
    User u2;
    UserStorage stoge;

    @Before
    public void setUp() {
        u1 = new User(1, 120);
        u2 = new User(2, 0);
        stoge = new UserStorage();
        stoge.add(u1);
        stoge.add(u2);
    }


    Runnable startTransfer(User usr1, User usr2, UserStorage stage) {
        Runnable r = () -> {
            int i = 0;
            while (i < 10) {
                i++;
                try {
                    stage.transfer(1, 2, 5);
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TransferException e) {
                    e.printStackTrace();
                    break;
                }
            }
        };
        return r;
    }


    @Test
    public void whenExecute2ThreadThen20() throws InterruptedException {
        Thread first = new Thread(startTransfer(u1, u2, stoge));
        Thread second = new Thread(startTransfer(u1, u2, stoge));
        first.start();
        second.start();
        first.join();
        second.join();
        assertThat(u1.getAmount(), is(20));
    }

}
