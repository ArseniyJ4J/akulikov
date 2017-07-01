package ru.job4j.shapes;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for Paint.
 * @author Arseniy Kulkiov (mailto:arsmail424@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class PaintTest {
    /**
     * Test.
     */
    @Test
    public void testForTriangle() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint();
        paint.draw(new Triangle());
        String line = System.getProperty("line.separator");
        String expected = String.format("  *%s ***%s*****%s", line, line, line);
        assertThat(out.toString(), is(expected));
    }
    /**
     * Test.
     */
    @Test
    public void testForSquare() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Paint paint = new Paint();
        paint.draw(new Square());
        String line = System.getProperty("line.separator");
        String expected = String.format(" ****%s *  *%s *  *%s ****%s", line, line, line, line);
        assertThat(out.toString(), is(expected));
    }
}
