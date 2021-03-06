package ru.job4j.array;
/**
* Class Bubble sort of numbers.
* @author akulikov
* @since 05.05.2017
* @version 1
*/
public class BubbleSort {
	/**
	* Метод выполняющий сортировку чисел в массиве "пузырьком".
	* @param array - массив целых чисел.
	* @return - возвращение.
	*/
	public int[] sort(int[] array) {
	int limit = array.length - 1;
	for (int i1 = limit; i1 >= 1; i1--) {
		int i;
		for (i = 0; i < i1;  i++) {
			int buffer;
			if (array[i] > array[i + 1]) {
				buffer = array[i];
				array[i] = array[i + 1];
				array[i + 1] = buffer;
			}
		}
	}
	return array;
	}
}