package ru.job4j.calculator;
/**
* Class Класс для выполнения арифметических вычислений без ввода-вывода.
* @author akulikov
* @since 28.04.2017
* @version 1
*/
public class Calculator {
	/**
	* @param result - результат.
	*/
	private double result;
	/**
	* Метод выполняющий сложение двух переменных.
	* @param first - первая переменная.
	* @param second - вторая переменная.
	*/
	public void add(double first, double second) {
		this.result = first + second;
	}
	/**
	* Метод возвращающий результат.
	* @return - возвращение.
	*/
	public double getResult() {
		return this.result;
	}
		/**
		* Метод выполняющий вычитание переменной first из переменной second.
		* @param first - первая переменная.
		* @param second - вторая переменная.
		*/
		public void substruct(double first, double second) {
			this.result = first - second;
		}
	/**
	* Метод выполняющий деление переменной first на переменную second.
	* @param first - первая переменная.
	* @param second - вторая переменная.
	*/
	public void div(double first, double second) {
		this.result = first / second;
	}
		/**
		* Метод выполняющий умножение переменных first и second.
		* @param first - первая переменная.
		* @param second - вторая переменная.
		*/
		public void multiple(double first, double second) {
			this.result = first * second;
		}
}