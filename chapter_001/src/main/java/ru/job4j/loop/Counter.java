package ru.job4j.loop;
/**
* Class Класс для вычисления суммы всех четных чисел в указаном диапазоне.
* @author akulikov
* @since 02.05.2017
* @version 1
*/
public class Counter {
	/**
	* Метод выполняющий отбор и сложение чисел в диапазоне.
	* @param start - нижнее значение диапазона.
	* @param finish - верхнее значение диапазона.
	* @return - возвращение значения суммы чисел.
	*/
	public int add(int start, int finish) {
		//for (; start <= finish; start++) {
		int result = 0;
		for (int index = start;  index <= finish; index++) {
			if (index % 2 == 0) {
			result = result + index;
			}
		}
		return result;
	}
}