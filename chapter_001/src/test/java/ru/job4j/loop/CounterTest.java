package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test for Counter.
*
* @author Arseniy Kulikov (mailto:arsmail424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class CounterTest {
	/**
	* Test.
	*/
	@Test
	public void counterBetweenTwoNumbers() {
	Counter count = new Counter();
	int result = count.add(0, 12);
	assertThat(result, is(42));
	}
}