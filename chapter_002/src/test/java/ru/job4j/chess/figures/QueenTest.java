package ru.job4j.chess.figures;

import org.junit.Test;
import ru.job4j.chess.Cell;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Тест-класс RookTest.
 * @author Arseniy Kulkiov
 * @since 26.07.2017
 * @version 1
 */
public class QueenTest {
    /**
     * Тест ситуации, когда клетка dist находится слева по-горизонтали от source.
     */
    @Test
    public void wayTest1() {
        Cell source = new Cell(5, 4);
        Cell dist = new Cell(2, 4);
        Queen queen = new Queen(source);
        Cell[] res = queen.way(dist);
        Cell[] ex = new Cell[] {new Cell(2, 4), new Cell(3, 4), new Cell(4, 4)};
        String result = String.valueOf(res[0].getX() + res[0].getY() + res[1].getX() + res[1].getY() + res[2].getX() + res[2].getY());
        String expect = String.valueOf(ex[0].getX() + ex[0].getY() + ex[1].getX() + ex[1].getY() + ex[2].getX() + ex[2].getY());
        assertThat(expect, is(result));
    }
    /**
     * Тест ситуации, когда клетка dist находится вертикально сверху от source.
     */
    @Test
    public void wayTest2() {
        Cell source = new Cell(5, 4);
        Cell dist = new Cell(5, 7);
        Queen queen = new Queen(source);
        Cell[] res = queen.way(dist);
        Cell[] ex = new Cell[] {new Cell(5, 7), new Cell(5, 6), new Cell(5, 5)};
        String result = String.valueOf(res[0].getX() + res[0].getY() + res[1].getX() + res[1].getY() + res[2].getX() + res[2].getY());
        String expect = String.valueOf(ex[0].getX() + ex[0].getY() + ex[1].getX() + ex[1].getY() + ex[2].getX() + ex[2].getY());
        assertThat(expect, is(result));
    }
    /**
     * Тест ситуации, когда клетка dist находится справа по-горизонтали от source.
     */
    @Test
    public void wayTest3() {
        Cell source = new Cell(5, 4);
        Cell dist = new Cell(8, 4);
        Queen queen = new Queen(source);
        Cell[] res = queen.way(dist);
        Cell[] ex = new Cell[] {new Cell(8, 4), new Cell(7, 4), new Cell(6, 4)};
        String result = String.valueOf(res[0].getX() + res[0].getY() + res[1].getX() + res[1].getY() + res[2].getX() + res[2].getY());
        String expect = String.valueOf(ex[0].getX() + ex[0].getY() + ex[1].getX() + ex[1].getY() + ex[2].getX() + ex[2].getY());
        assertThat(expect, is(result));
    }
    /**
     * Тест ситуации, когда клетка dist находится вертикально снизу от source.
     */
    @Test
    public void wayTest4() {
        Cell source = new Cell(5, 4);
        Cell dist = new Cell(5, 1);
        Queen queen = new Queen(source);
        Cell[] res = queen.way(dist);
        Cell[] ex = new Cell[] {new Cell(5, 1), new Cell(5, 2), new Cell(5, 3)};
        String result = String.valueOf(res[0].getX() + res[0].getY() + res[1].getX() + res[1].getY() + res[2].getX() + res[2].getY());
        String expect = String.valueOf(ex[0].getX() + ex[0].getY() + ex[1].getX() + ex[1].getY() + ex[2].getX() + ex[2].getY());
        assertThat(expect, is(result));
    }
    /**
     * Тест ситуации, когда клетка dist находится по-диагонали слева вниз от source.
     */
    @Test
    public void wayTest5() {
        Cell source = new Cell(5, 4);
        Cell dist = new Cell(2, 1);
        Queen queen = new Queen(source);
        Cell[] res = queen.way(dist);
        Cell[] ex = new Cell[] {new Cell(2, 1), new Cell(3, 2), new Cell(4, 3)};
        String result = String.valueOf(res[0].getX() + res[0].getY() + res[1].getX() + res[1].getY() + res[2].getX() + res[2].getY());
        String expect = String.valueOf(ex[0].getX() + ex[0].getY() + ex[1].getX() + ex[1].getY() + ex[2].getX() + ex[2].getY());
        assertThat(expect, is(result));
    }
    /**
     * Тест ситуации, когда клетка dist находится по-дигонали слева вверх от source.
     */
    @Test
    public void wayTest6() {
        Cell source = new Cell(5, 4);
        Cell dist = new Cell(2, 7);
        Queen queen = new Queen(source);
        Cell[] res = queen.way(dist);
        Cell[] ex = new Cell[] {new Cell(2, 7), new Cell(3, 6), new Cell(4, 5)};
        String result = String.valueOf(res[0].getX() + res[0].getY() + res[1].getX() + res[1].getY() + res[2].getX() + res[2].getY());
        String expect = String.valueOf(ex[0].getX() + ex[0].getY() + ex[1].getX() + ex[1].getY() + ex[2].getX() + ex[2].getY());
        assertThat(expect, is(result));
    }
    /**
     * Тест ситуации, когда клетка dist находится по-диагонали справа вверх от source.
     */
    @Test
    public void wayTest7() {
        Cell source = new Cell(5, 4);
        Cell dist = new Cell(8, 7);
        Queen queen = new Queen(source);
        Cell[] res = queen.way(dist);
        Cell[] ex = new Cell[] {new Cell(8, 7), new Cell(7, 6), new Cell(6, 5)};
        String result = String.valueOf(res[0].getX() + res[0].getY() + res[1].getX() + res[1].getY() + res[2].getX() + res[2].getY());
        String expect = String.valueOf(ex[0].getX() + ex[0].getY() + ex[1].getX() + ex[1].getY() + ex[2].getX() + ex[2].getY());
        assertThat(expect, is(result));
    }
    /**
     * Тест ситуации, когда клетка dist находится по-диагонали справа вниз от source.
     */
    @Test
    public void wayTest8() {
        Cell source = new Cell(5, 4);
        Cell dist = new Cell(8, 1);
        Queen queen = new Queen(source);
        Cell[] res = queen.way(dist);
        Cell[] ex = new Cell[] {new Cell(8, 1), new Cell(7, 2), new Cell(6, 3)};
        String result = String.valueOf(res[0].getX() + res[0].getY() + res[1].getX() + res[1].getY() + res[2].getX() + res[2].getY());
        String expect = String.valueOf(ex[0].getX() + ex[0].getY() + ex[1].getX() + ex[1].getY() + ex[2].getX() + ex[2].getY());
        assertThat(expect, is(result));
    }
}
