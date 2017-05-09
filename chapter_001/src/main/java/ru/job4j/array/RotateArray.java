package ru.job4j.array;
/**
* Class Класс, поворачивающий двумерный массив на 90 градусов по часовой.
* @author akulikov
* @since 09.05.2017
* @version 1
*/
public class RotateArray {
	/**
	* Метод выполняющий поворот двумерного массива на 90 градусов по часовой.
	* @param array - массив целых чисел.
	* @return - возвращение.
	*/
	public int[][] rotate(int[][] array) {
	int lim = array.length - 1;
	int[][] buffer = new int[lim][lim];
		for  (int i = 0; i < lim; i++) {
			for (int j = 0; j < lim; j++) {
				buffer[j][lim - i] = array[i][j];
			}
		}
	return buffer;
	}
}