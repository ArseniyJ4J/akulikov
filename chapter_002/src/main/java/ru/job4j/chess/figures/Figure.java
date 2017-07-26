package ru.job4j.chess.figures;

import ru.job4j.chess.exceptions.ImposibleMoveException;
import ru.job4j.chess.Cell;

/** Абстрактный класс Figure.
 * @author Arseniy Kulkiov
 * @since 25.07.2017
 * @version 1
 */
public abstract class Figure {
    /**
     * Константа. Позиция - клетка на которой находится фигура.
     */
    private final Cell position;
    /**
     * Конструктор.
     * @param position - начальная позиция фигуры.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Геттер для position.
     * @return - возврат значения.
     */
    public Cell getPosition() {
        return this.position;
    }
    /**
     * Метод way - возращает массив клеток, которые должна пройти фигура для перемещения на клетку dist.
     * @param dist - конечная клетка перемещения.
     * @return - возврат массива клеток.
     * @throws ImposibleMoveException - исключение. Срабатывает, когда фигура не может походить на клетку dist.
     */
    public abstract Cell[] way(Cell dist) throws ImposibleMoveException;

    /**
     * Метод замещающий фигуру на себя же, но перемещенную на клетку dist.
     * @param dist - конечная клетка перемещения.
     * @return - возврат.
     */
    public abstract Figure clone(Cell dist);
}
