package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test for Calculator.
*
* @author Arseniy Kulikov (mailto:arsmil424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class CalculatorTest {
	/**
	* Test.
	*/
	@Test
	public void whenAddOnePlusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.add(1D, 1D);
		double result = calc.getResult();
		double expected = 2D;
		assertThat(result, is(expected));
	}
	/**
	*Test.
	*/
	@Test
	public void whenAddOneMinusOneThenTwo() {
		Calculator calc = new Calculator();
		calc.substruct(5D, 2D);
		double result = calc.getResult();
		double expected = 3D;
		assertThat(result, is(expected));
	}
	/**
	*Test.
	*/
	@Test
	public void whenAddOnePartOneThenTwo() {
		Calculator calc = new Calculator();
		calc.div(6D, 2D);
		double result = calc.getResult();
		double expected = 3D;
		assertThat(result, is(expected));
	}
	/**
	*Test.
	*/
	@Test
	public void whenAddOneMachOneThenTwo() {
		Calculator calc = new Calculator();
		calc.multiple(3D, 4D);
		double result = calc.getResult();
		double expected = 12D;
		assertThat(result, is(expected));
	}
}