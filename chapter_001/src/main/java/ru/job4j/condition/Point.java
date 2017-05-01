package ru.job4j.condition;
/** Class Класс для проверки принадлежность координат точки к функции прямой.
* @author Arseniy Kulkiov
* @since 29.04.2017
* @version 1
*/
public class Point {
	/**
	* Объявление переменной x в поле класса.
	* @param x - "x" coordinate.
	*/
	private int x;
	/**
	* Объявление переменной y в поле класса.
	* @param y - "y" coordonate.
	*/
	private int y;
	/**
	* Метод присвоения значений переменным x,y.
	* @param x - "x" coordinate.
	* @param y - "y" coordonate.
	*/
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	* Метод возвращения значения.
	* @return - возвращение.
	*/
	public int getX() {
		return this.x;
	}
	/**
	* Метод возвращения значения.
	* @return - возвращение.
	*/
	public int getY() {
		return this.y;
	}
	/**
	* Метод определения принадлежности точки к прямой.
	* @return - возвращение.
	* @param a - постоянная a.
	* @param b - постоянная b.
	*/
	public boolean is(int a, int b) {
		return this.getY() == a * this.getX() + b;
	}
}