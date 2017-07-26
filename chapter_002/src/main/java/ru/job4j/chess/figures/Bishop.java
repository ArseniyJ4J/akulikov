package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.ImposibleMoveException;

/** Класс Bishop. Шахматная фигура "слон".
 * @author Arseniy Kulkiov
 * @since 20.07.2017
 * @version 1
 */

public class Bishop extends Figure {
    /**
     * Конструктор.
     * @param position - позиция фигуры.
     */
    public Bishop(Cell position) {
        super(position);
        if (!(this.correctDiapasone(position))) {
            throw new ImposibleMoveException("Указанная клетка находится за пределами шахматной доски (8х8).");
        }
    }

    /**
     * Метод way - возращает массив клеток, которые должна пройти фигура для перемещения на клетку dist.
     * @param dist - конечная клетка перемещения.
     * @return - возврат массива клеток.
     * @throws ImposibleMoveException - исключение. Срабатывает, когда фигура не может походить на клетку dist.
     */
    @Override
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        Cell[] way = new Cell[Math.abs(dist.getX() - this.getPosition().getX())];
        if (!(this.correctDiapasone(dist))) {
            throw new ImposibleMoveException("Указанная клетка находится за пределами шахматной доски (8х8).");
        }
        if (Math.abs(dist.getX() - Math.abs(this.getPosition().getX())) == Math.abs(dist.getY() - Math.abs(this.getPosition().getY()))) {
            int deltaX = dist.getX() - this.getPosition().getX();
            int deltaY = dist.getY() - this.getPosition().getY();
            if (deltaX > 0 && deltaY > 0) {
                for (int i = 0; i < Math.abs(deltaX); i++) {
                    way[Math.abs(deltaX) - (1 + i)] = new Cell(dist.getX() - i, dist.getY() - i);
                    //way[Math.abs(deltaX) - i].setX(dist.getX() - i);
                    //way[Math.abs(deltaX) - i].setY(dist.getY() - i);
                }
            }
            if (deltaX > 0 && deltaY < 0) {
                for (int i = 0; i < Math.abs(deltaX); i++) {
                    way[Math.abs(deltaX) - (1 + i)] = new Cell(dist.getX() - i, dist.getY() + i);
                    //way[Math.abs(deltaX) - i].setX(dist.getX() - i);
                    //way[Math.abs(deltaX) - i].setY(dist.getY() + i);
                }
            }
            if (deltaX < 0 && deltaY < 0) {
                for (int i = 0; i < Math.abs(deltaX); i++) {
                    way[Math.abs(deltaX) - (1 + i)] = new Cell(dist.getX() + i, dist.getY() + i);
                    //way[Math.abs(deltaX) - (i + 1)].setX(dist.getX() + i);
                    //way[Math.abs(deltaX) - (i + 1)].setY(dist.getY() + i);
                }
            }
            if (deltaX < 0 && deltaY > 0) {
                for (int i = 0; i < Math.abs(deltaX); i++) {
                    way[Math.abs(deltaX) - (1 + i)] = new Cell(dist.getX() + i, dist.getY() - i);
                    //way[Math.abs(deltaX) - i].setX(dist.getX() + i);
                    //way[Math.abs(deltaX) - i].setY(dist.getY() - i);
                }
            }
        } else {
            throw new ImposibleMoveException("Такой ход невозможен для данной фигуры.");
        }
        return way;
    }

    @Override
    public Figure clone(Cell dist) {
        return new Bishop(dist);
    }

    /**
     * Метод проверяющий, что клетка cell находится в пределах шахматной доски.
     * @param cell - проверяемая клетка.
     * @return - возврат значения.
     */
    private boolean correctDiapasone(Cell cell) {
        boolean result = false;
        if (cell.getX() >= 1 && cell.getX() <= 8
                && cell.getY() >= 1 && cell.getY() <= 8) {
            result = true;
        }
        return result;
    }

}
