package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test for Factorial.
*
* @author Arseniy Kulikov (mailto:arsmail424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class FactorialTest {
	/**
	* Test.
	*/
	@Test
	public void factorialPositiveNumber() {
		Factorial factor = new Factorial();
		int result = factor.calc(5);
		assertThat(result, is(120));
	}
	/**
	* Test.
	*/
	@Test
	public void factorialZeroNumber() {
		Factorial factor = new Factorial();
		int result = factor.calc(0);
		assertThat(result, is(1));
	}
}