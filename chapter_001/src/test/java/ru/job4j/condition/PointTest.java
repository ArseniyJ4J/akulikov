package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test for Point.
*
* @author Arseniy Kulikov (mailto:arsmail424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class PointTest {
	/**
	* Test.
	*/
	@Test
	public void pointOnLine() {
		Point point = new Point(6, 15);
		boolean result = point.is(2, 3);
		assertThat(result, is(true));
	}
}