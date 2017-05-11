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
public class ArrayDuplicateTest {
	/**
	* Test.
	*/
	@Test
	public void deleteDuplicateFiveStringArray() {
	ArrayDuplicate ad = new ArrayDuplicate();
	String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
	String[] resultArray = ad.remove(array);
	String[] expectArray = {"Привет", "Мир", "Супер"};
	assertThat(resultArray, is(expectArray));
	}
}