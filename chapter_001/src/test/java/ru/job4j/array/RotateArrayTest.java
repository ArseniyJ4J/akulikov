package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test for RotateArray.
* @author Arseniy Kulikov (mailto:arsmail424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class RotateArrayTest {
	/**
	* Test.
	*/
	@Test
	public void rotateArrayOnQuarterThree() {
		RotateArray ra = new RotateArray();
		int[][]array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] resultArray = ra.rotate(array);
		int[][] expectArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		assertThat(resultArray, is(expectArray));
	}
	/**
	* Test.
	*/
	@Test
	public void rotateArrayOnQuarterTwo() {
		RotateArray ra = new RotateArray();
		int[][]array = {{1, 2}, {3, 4}};
		int[][] resultArray = ra.rotate(array);
		int[][] expectArray = {{3, 1}, {4, 2}};
		assertThat(resultArray, is(expectArray));
	}
}