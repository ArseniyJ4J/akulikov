package ru.job4j.chess.figures;

import ru.job4j.chess.Cell;
import ru.job4j.chess.exceptions.ImposibleMoveException;

/** Класс Rook. Шахматная фигура "ладья".
 * @author Arseniy Kulkiov
 * @since 26.07.2017
 * @version 1
 */

public class Rook extends Figure {
    /**
     * Конструктор.
     * @param position - клетка на которой находится фигура.
     */
    public Rook(Cell position) {
        super(position);
        if (!(this.correctDiapasone(position))) {
            throw new ImposibleMoveException("Указанная клетка находится за пределами шахматной доски (8х8).");
        }
    }

    @Override
    public Cell[] way(Cell dist) throws ImposibleMoveException {
        int deltaX = dist.getX() - this.getPosition().getX();
        int deltaY = dist.getY() - this.getPosition().getY();
        int delta = Math.abs(deltaX + deltaY);
        Cell[] way = new Cell[delta];
        if (!(this.correctDiapasone(dist))) {
            throw new ImposibleMoveException("Указанная клетка находится за пределами шахматной доски (8х8).");
        }
        if (Math.abs(delta) == Math.abs(deltaX) || Math.abs(delta) == Math.abs(deltaY)) {
            if (deltaX < 0 && deltaY == 0) {
                for (int i = 0; i < delta; i++) {
                    way[delta - (1 + i)] = new Cell(dist.getX() + i, dist.getY());
                }
            }
            if (deltaX > 0 && deltaY == 0) {
                for (int i = 0; i < delta; i++) {
                    way[delta - (1 + i)] = new Cell(dist.getX() - i, dist.getY());
                }
            }
            if (deltaX == 0 && deltaY < 0) {
                for (int i = 0; i < delta; i++) {
                    way[delta - (1 + i)] = new Cell(dist.getX(), dist.getY() + i);
                }
            }
            if (deltaX == 0 && deltaY > 0) {
                for (int i = 0; i < delta; i++) {
                    way[delta - (1 + i)] = new Cell(dist.getX(), dist.getY() - i);
                }
            }
        } else {
            throw new ImposibleMoveException("Такой ход невозможен для данной фигуры.");
        }
        return way;
    }

    @Override
    public Figure clone(Cell dist) {
        return new Rook(dist);
    }
}
