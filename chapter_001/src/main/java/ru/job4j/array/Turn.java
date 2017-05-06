package ru.job4j.array;
/**
* Class Класс переворачивающий массив.
* @author akulikov
* @since 05.05.2017
* @version 1
*/
public class Turn {
	/**
	* Метод выполняющий "переворачивание" массива.
	* @param array - массив целых чисел.
	* @return - возвращение.
	*/
	public int[] back(int[] array) {
	for (int i = 0; i < array.length / 2; i++) {
	int buffer = array[i];
	array[i] = array[array.length - i - 1];
	array[array.length - i - 1] = buffer;
	}
	return array;
	}
}