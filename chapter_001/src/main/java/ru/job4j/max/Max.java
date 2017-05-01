package ru.job4j.max;
/**
* Class for Max result.
* @author akulikov
* @since 29.04.2017
* @version 1
*/
public class Max {
	/**
	* Метод выполняющий возвращение максимального значения из двух.
	* @param first - первая переменная.
	* @param second - вторая переменная.
	* @return - возвращение переменной.
	*/
	public int max(int first, int second) {
		return first >= second ? first : second;
	}
}