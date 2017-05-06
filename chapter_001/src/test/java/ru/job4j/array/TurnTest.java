package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test for Turn.
* @author Arseniy Kulikov (mailto:arsmail424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class TurnTest {
	/**
	* Test.
	*/
	@Test
	public void whenTurnArrayWithFourElements() {
		Turn turn = new Turn();
		int[] array = {2, 4, 7, 8};
		int[] resultArray = turn.back(array);
		int[] expectArray = {8, 7, 4, 2};
		assertThat(resultArray, is(expectArray));
	}
	/**
	* Test.
	*/
	@Test
	public void whenTurnArrayWithSevenElements() {
		Turn turn = new Turn();
		int[] array = {2, 4, 7, 8, 12, 3, 9};
		int[] resultArray = turn.back(array);
		int[] expectArray = {9, 3, 12, 8, 7, 4, 2};
		assertThat(resultArray, is(expectArray));
	}
}