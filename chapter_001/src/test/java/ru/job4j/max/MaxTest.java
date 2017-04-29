package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test for Max.
*
* @author Arseniy Kulikov (mailto:arsmail424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class MaxTest {
	/**
	* Test.
	*/
	@Test
	public void testMax() {
		Max maximum = new Max();
		int result = maximum.max(4, 8);
		assertThat(result, is(8));
	}
}