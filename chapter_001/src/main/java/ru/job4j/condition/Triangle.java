package ru.job4j.condition;
/** Class класс для вычисления площади треугольника по координатам вершин.
* @author Arseniy Kulkiov
* @since 30.04.2017
* @version 1
*/
public class Triangle {
	/**
	* Объявление объекта Point a - одна из вершин.
	* @param Point a - одна из вершин.
	*/
	private Point a;
	/**
	* Объявление объекта Point b - одна из вершин.
	* @param Point b - одна из вершин.
	*/
	private Point b;
	/**
	* Объявление объекта Point c - одна из вершин.
	* @param Point c - одна из вершин.
	*/
	private Point c;
	/**
	* Конструктор треугольника.
	* @param a - "a" - вершина.
	* @param b - "b" - вершина.
	* @param c - "c" - вершина.
	*/
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	/**
	* Метод вычисления площади треугольника.
	* @return - возвращение.
	*/
	public double area() {
		//return ((a(x)-c(x)) * (b(y)-c(y))-(b(x)-c(x))*(a(y)-c(y))/2;
		double skobki = (Math.abs((a.getX() - c.getX()) * (b.getY() - c.getY()) - (b.getX() - c.getX()) * (a.getY() - c.getY())));
		if (skobki == 0) {
		return skobki;
		} else {
		return skobki / 2;
		}
	}
}