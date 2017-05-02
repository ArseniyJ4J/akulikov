package ru.job4j.loop;
/**
* Class Класс вычисления факториала числа.
* @author akulikov
* @since 02.05.2017
* @version 1
*/
public class Factorial {
	/**
	* Метод выполняющий вычисление факториала числа.
	* @param n - чило факториал которого будет вычисляться.
	* @return - возвращение значения суммы чисел.
	*/
public int calc(int n) {
	int result = 1;
		if (n == 0) {
		return result;
		} else {
		for (int index = 1; index <= n; index++) {
		result = result * index;
		}
		}
		return result;
	}
}