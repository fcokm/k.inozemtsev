package ru.job4j.thread;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.stringContainsInOrder;

public class CachNotBlockTest {
    CachNotBlock notBlock;

    Base firstModel;
    Base secondModel;
    Thread t1;
    Thread t2;
    Thread t3;
    int count;

    @Before
    public void setUp() throws Exception {
        notBlock = new CachNotBlock();
        firstModel = new Base(1);
        firstModel.setName("Jo");
        secondModel = new Base(2);
        notBlock.add(firstModel);

        count = 0;
    }

    @Test
    public void whenThreadPoolTest() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                       /* IntStream.range(0, 10)
                                .forEach(i -> {
                                    firstModel.setId(i);
                                    notBlock.update(firstModel);
                                });*/

                        for (int i = 2; i < 100; i++) {
                            firstModel.setName(firstModel.getName()+ i);
                            notBlock.update(firstModel);
                        }

                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );


        Thread thread1 = new Thread(
                () -> {
                    try {
                     /*   IntStream.range(10, 20)
                                .forEach(i -> {
                                    firstModel.setId(i);
                                    notBlock.update(firstModel);
                                });*/

                        for (int i = 101; i < 170; i++) {
                            firstModel.setName(firstModel.getName()+ i);
                            notBlock.update(firstModel);
                        }

                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );

        Runnable r1 = () -> {
            try {

                for (int i = 2; i < 100; i++) {
                    firstModel.setName("name: " + i);
                    notBlock.update(firstModel);
                }

            } catch (Exception e) {
                ex.set(e);
            }
         };

        Runnable r2 = () -> {
            try {

                for (int i = 102; i < 250; i++) {
                    firstModel.setName("name: " + i);
                    notBlock.update(firstModel);
                }

            } catch (Exception e) {
                ex.set(e);
            }
        };


        Runnable r3 = () -> {
            try {

                for (int i = 251; i < 370; i++) {
                    firstModel.setName("name: " + i);
                    notBlock.update(firstModel);
                }

            } catch (Exception e) {
                ex.set(e);
            }
        };

        Runnable r4 = () -> {
            try {

                for (int i = 380; i < 570; i++) {
                    firstModel.setName("name: " + i);
                    notBlock.update(firstModel);
                }

            } catch (Exception e) {
                ex.set(e);
            }
        };


        Runnable r5 = () -> {
            try {

                for (int i = 580; i < 870; i++) {
                    firstModel.setName("name: " + i);
                    notBlock.update(firstModel);
                }

            } catch (Exception e) {
                ex.set(e);
            }
        };


        Thread thread2 = new Thread(
                () -> {
                    try {
                     /*   IntStream.range(20, 30)
                               .forEach(i -> {
                                   firstModel.setId(i);
                                   notBlock.update(firstModel);
                               });*/


                        for (int i = 172; i < 250; i++) {
                            firstModel.setName(firstModel.getName()+ i);
                            notBlock.update(firstModel);
                        }

                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );

        Thread thread3 = new Thread(
                () -> {
                    try {
                     /*   IntStream.range(30, 40)
                                .forEach(i -> {
                                    int x = i +i;
                                    firstModel.setId( i);
                                    notBlock.update(firstModel);
                                });
*/
                        for (int i = 260; i < 370; i++) {
                            firstModel.setName(firstModel.getName()+ i);
                            notBlock.update(firstModel);
                        }

                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );


        Thread thread4 = new Thread(
                () -> {
                    try {
                     /*   IntStream.range(30, 40)
                                .forEach(i -> {
                                    int x = i +i;
                                    firstModel.setId( i);
                                    notBlock.update(firstModel);
                                });
*/
                        for (int i = 370; i < 570; i++) {
                            firstModel.setName(firstModel.getName()+ i);
                            notBlock.update(firstModel);
                        }

                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );


        Thread th1 = new Thread(r1);
        Thread th2 = new Thread(r2);
        Thread th3 = new Thread(r3);
        Thread th4 = new Thread(r4);
        Thread th5 = new Thread(r5);

        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();

        th1.join();
        th2.join();
        th3.join();
        th4.join();
        th5.join();

   /*     thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread.join();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();*/




        notBlock.getBaseMap().forEach((k, v) -> {
            System.out.println(k + "  " + v);
        });


     /*   IntStream.range(0, 10)
                .peek(i -> {
                    System.out.println("Test number " + i + " started.");
                    firstModel.setId(5);
                    notBlock.update(firstModel);
                })
                .forEach(System.out::println);*/
        System.out.println(ex);
//        Assert.assertThat(ex.get().getMessage(), is("Diff version"));

    }

    @Test
    public void whenThrowExceptin() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                        throw new RuntimeException("Throw Exception in Thread");
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        thread.start();
        thread.join();
        Assert.assertThat(ex.get().getMessage(), is("Throw Exception in Thread"));
    }


}
