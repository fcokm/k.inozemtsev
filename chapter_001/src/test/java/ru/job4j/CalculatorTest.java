package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



/**
 * Calculator.
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

   public class CalculatorTest {

        /**
         * Test echo.
         */
       @Test
        public void whenTakeNameThenTreeEchoPlusName() {
            String input = "Konstantin Inozemcev";
            String expect = "Echo, echo, echo : Konstantin Inozemcev";
            Calculate calc = new Calculate();
            String result = calc.echo(input);
            assertThat(result, is(expect));
        }

    }


