package ru.job4j.tracker;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.pseudo.Paint;
import ru.job4j.pseudo.Square;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class StartUITest {

/*    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }*/


/*    @Test
    public void whenUserAddTwoItemsThenGetAllIttems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "desc1");
        tracker.add(first);
        Item second = new Item("test2", "desc2");
        tracker.add(second);
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();

           assertThat(
                    new String(out.toByteArray()),
                    is(
                            new StringBuilder()
                                    .append(" Меню.\n")
                                    .append(" 0. Добавить новую заявку.\n")
                                    .append(" 1. Показать все заявки.\n")
                                    .append(" 2. Редактировать заявку.\n")
                                    .append(" 3. Удалить заявку.\n")
                                    .append(" 4. Найти  заявку по id.\n")
                                    .append(" 5. Найти заявку по имени.\n")
                                    .append(" 6. Завершить программу.\n")
                                    .append("------------ Список всех заявок --------------\r\n")
                                    .append("Заявка :")
                                    .append("   ")
                                    .append(tracker.getAll()[0])
                                    .append(" \n")
                                    .append("Заявка :")
                                    .append("   ")
                                    .append(tracker.getAll()[1])
                                    .append(" \n")
                                    .append(" Меню.\n")
                                    .append(" 0. Добавить новую заявку.\n")
                                    .append(" 1. Показать все заявки.\n")
                                    .append(" 2. Редактировать заявку.\n")
                                    .append(" 3. Удалить заявку.\n")
                                    .append(" 4. Найти  заявку по id.\n")
                                    .append(" 5. Найти заявку по имени.\n")
                                    .append(" 6. Завершить программу.\n")
                                    .toString()
                    )
            );
            System.setOut(stdout);

    }


    @Test
    public void whenUserAddTwoItemsThenFindByIdItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "desc1");
        tracker.add(first);
        Item second = new Item("test2", "desc2");
        tracker.add(second);
        Item it = tracker.findById(first.getId());
        Input input = new StubInput(new String[]{"4", it.getId(), "6"});
        new StartUI(input, tracker).init();

        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(" Меню.\n")
                                .append(" 0. Добавить новую заявку.\n")
                                .append(" 1. Показать все заявки.\n")
                                .append(" 2. Редактировать заявку.\n")
                                .append(" 3. Удалить заявку.\n")
                                .append(" 4. Найти  заявку по id.\n")
                                .append(" 5. Найти заявку по имени.\n")
                                .append(" 6. Завершить программу.\n")
                                .append("------------ Получение заявки по Id --------------\r\n")
                                .append("Заявка :")
                                .append(" ")
                                .append(tracker.getAll()[0])
                                .append("\n")
                                .append(" Меню.\n")
                                .append(" 0. Добавить новую заявку.\n")
                                .append(" 1. Показать все заявки.\n")
                                .append(" 2. Редактировать заявку.\n")
                                .append(" 3. Удалить заявку.\n")
                                .append(" 4. Найти  заявку по id.\n")
                                .append(" 5. Найти заявку по имени.\n")
                                .append(" 6. Завершить программу.\n")
                                .toString()
                )
        );
        System.setOut(stdout);
    }

    @Test
    public void whenUserAddTwoItemsThenFindByNameItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1", "desc1");
        tracker.add(first);
        Item second = new Item("test2", "desc2");
        tracker.add(second);
        Input input = new StubInput(new String[]{"5", "test2", "6"});
        new StartUI(input, tracker).init();

        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(" Меню.\n")
                                .append(" 0. Добавить новую заявку.\n")
                                .append(" 1. Показать все заявки.\n")
                                .append(" 2. Редактировать заявку.\n")
                                .append(" 3. Удалить заявку.\n")
                                .append(" 4. Найти  заявку по id.\n")
                                .append(" 5. Найти заявку по имени.\n")
                                .append(" 6. Завершить программу.\n")
                                .append("------------ Получение заявки по имени --------------\r\n")
                                .append("Заявка :")
                                .append(" ")
                                .append(tracker.getAll()[1])
                                .append("\n")
                                .append(" Меню.\n")
                                .append(" 0. Добавить новую заявку.\n")
                                .append(" 1. Показать все заявки.\n")
                                .append(" 2. Редактировать заявку.\n")
                                .append(" 3. Удалить заявку.\n")
                                .append(" 4. Найти  заявку по id.\n")
                                .append(" 5. Найти заявку по имени.\n")
                                .append(" 6. Завершить программу.\n")
                                .toString()
                )
        );
        System.setOut(stdout);
    }*/


    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item());
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"1", item.getId(), "test name", "desc", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));

    }
}