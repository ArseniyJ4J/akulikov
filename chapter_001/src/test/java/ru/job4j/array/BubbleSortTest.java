package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test for BubbleSort.
* @author Arseniy Kulikov (mailto:arsmail424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class BubbleSortTest {
	/**
	* Test.
	*/
	@Test
	public void sortElevenNumbers() {
		BubbleSort bs = new BubbleSort();
		int[] array = {9, 11, 3, 8, 10, 2, 5, 1, 7, 4, 6};
		int[] resultArray = bs.sort(array);
		int[] expectArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		assertThat(resultArray, is(expectArray));
	}
}