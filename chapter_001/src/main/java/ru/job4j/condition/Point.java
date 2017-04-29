package ru.job4j.condition;
/** Class ����� ��� �������� �������������� ��������� ����� � ������� ������.
* @author Arseniy Kulkiov
* @since 29.04.2017
* @version 1
*/
public class Point {
	/**
	* ���������� ���������� x � ���� ������.
	* @param x - "x" coordinate.
	*/
	private int x;
		/**
	* ���������� ���������� y � ���� ������.
	* @param y - "y" coordonate.
	*/
	private int y;
	/**
	* ����� ���������� �������� ���������� x,y.
	* @param x - "x" coordinate.
	* @param y - "y" coordonate.
	*/
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	* ����� ����������� ��������.
	* @return - �����������.
	*/
	public int getX() {
		return this.x;
	}
	/**
	* ����� ����������� ��������.
	* @return - �����������.
	*/
	public int getY() {
		return this.y;
	}
	/**
	* ����� ����������� �������������� ����� � ������.
	* @return - �����������.
	* @param a - ���������� a.
	* @param b - ���������� b.
	*/
	public boolean is(int a, int b) {
		return this.getY() == a * this.getX() + b;
	}
}