package ru.job4j.chess;

/**
 * Created by Ирина on 20.07.2017.
 */
public class Cell {
    /**
     * Поле класса. Координата x для клетки шахматной доски.
     */
    private int x;
    /**
     * Поле класса. Координата y для клетки шахматной доски.
     */
    private int y;
    /**
     * Конструктор.
     * @param x - координата x.
     * @param y - координата y.
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;

    }
    /**
     * Геттер для x.
     * @return возврат значения переменной поля класса x;
     */
    public int getX() {
        return this.x;
    }
    /**
     * Геттер для y.
     * @return возврат значения переменной поля класса y;
     */
    public int getY() {
        return this.y;
    }
}
