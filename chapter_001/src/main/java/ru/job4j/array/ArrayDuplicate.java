package ru.job4j.array;

import java.util.Arrays;
/**
* Class Delete duplicate of string array.
* @author akulikov
* @since 11.05.2017
* @version 1
*/
public class ArrayDuplicate {
	/**
	* Метод выполняющий удаление дубликатов в массиве строк.
	* @param array - массив строк.
	* @return - возвращение.
	*/
	public String[] remove(String[] array) {
		int lim = array.length - 1;
		int z = 0;
		for (int i = 0; i < lim; i++) {
			for (int e = i + 1; e <= lim - z; e++) {
				String buffer;
				if (array[i] == array[e]) {
				buffer = array[e];
				array[e] = array[lim - z];
				array[lim - z] = buffer;
				z++;
				e--;
				}
			}
			}
	return Arrays.copyOf(array, array.length - z);
	}
}