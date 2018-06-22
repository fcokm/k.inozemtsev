package ru.job4j.tracker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenTenInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"20", "1"})
        );
        input.ask("Введите пункт меню :", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Выбирете значение пункта из меню!\r\n")
                )
        );
    }

    @Test
    public void whenInvalidInpu() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Введите пункт меню :", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Введите корректное значение пункта из меню!\r\n")
                )
        );
    }
}
