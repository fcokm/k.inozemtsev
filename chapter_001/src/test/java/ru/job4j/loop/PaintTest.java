package ru.job4j.loop; 


import org.junit.Test;
import java.util.StringJoiner;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;



    public class PaintTest {

        @Test
        public void whenPyramid3() {
            Paint paint = new Paint();
            String rst = paint.pyramid(3);
            System.out.println(rst);
            assertThat(rst,
                    is(
                            new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                            .add("  ^  ")
                            .add(" ^^^ ")
                            .add("^^^^^")
                            .toString()
                     
            )
		  );	
        }
    }




