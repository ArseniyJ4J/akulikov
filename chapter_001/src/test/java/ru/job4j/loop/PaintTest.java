package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test for Paint.
*
* @author Arseniy Kulkiov (mailto:arsmail424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class PaintTest {
	/**
	* Test.
	*/
	@Test
	public void whenHeightThree() {
		Paint paint = new Paint();
		String result = paint.piramid(3);
		final String line = System.getProperty("line.separator");
		String expected = String.format("  ^%s ^^^%s^^^^^%s", line, line, line);
		assertThat(result, is(expected));
	}
	/**
	* Test.
	*/
	@Test
	public void whenHeightFour() {
		Paint paint = new Paint();
		String result = paint.piramid(4);
		final String line = System.getProperty("line.separator");
		String expected = String.format("   ^%s  ^^^%s ^^^^^%s^^^^^^^%s", line, line, line, line);
		assertThat(result, is(expected));
	}
}