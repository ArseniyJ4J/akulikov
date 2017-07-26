package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImposibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.figures.Figure;

/** Абстрактный класс Figure.
 * @author Arseniy Kulkiov
 * @since 25.07.2017
 * @version 1
 */

public class Board {
    /**
     * Поле класса. Массив содержащий шахматные фигуры.
     */
    private Figure[] figures = new Figure[32];

    /**
     * Геттер для figures.
     * @return - возврат значения.
     */
    public Figure[] getFigures() {
        return this.figures;
    }
    /**
     * Метод перемещения фигуры.
     * @param source - исходная клетка.
     * @param dist - конечная клетка.
     * @return - возврат значения.
     * @throws ImposibleMoveException - исключение. Срабатывает, когда фигура не может походить на клетку dist.
     * @throws OccupiedWayException - исключение. Срабатывает, когда на пути движения фигуры находится другая фигура (не срабатывает для коня).
     * @throws FigureNotFoundException - исключение. Срабатывает, когда на клетке source нет никакой фигуры.
     */
    public boolean move(Cell source, Cell dist) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure movingFigure = null;
        int check = 0;
        for (Figure fig : this.getFigures()) {
            if (fig != null && fig.getPosition().equals(source)) {
                movingFigure = fig;
                check = 1;
            }
        }
        if (check == 0) {
            throw new FigureNotFoundException("В исходной ячейке отсутствует фигура.");
        }
        Cell[] resultWay = movingFigure.way(dist);
        for (Cell cellWay : resultWay) {
            for (Figure fig : this.getFigures()) {
                if (fig != null && fig.getPosition().equals(cellWay)) {
                    throw new OccupiedWayException("Путь движения занят другой фигурой.");
                }
            }
        }
        for (int i = 0; i < this.getFigures().length; i++) {
            if (this.getFigures()[i] != null && this.getFigures()[i].getPosition().equals(source)) {
                this.getFigures()[i] = this.getFigures()[i].clone(dist);
            }
        }
        return true;
    }
}
