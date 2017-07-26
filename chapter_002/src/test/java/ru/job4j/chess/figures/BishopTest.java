package ru.job4j.chess.figures;

import org.junit.Test;
import ru.job4j.chess.Cell;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Тест-класс BishopTest.
 * @author Arseniy Kulkiov
 * @since 25.07.2017
 * @version 1
 */
public class BishopTest {

    /**
     * Test.
     */
    @Test
    public void wayTest1() {
        Cell source = new Cell(5, 4);
        Cell dist = new Cell(2, 1);
        Bishop bishop = new Bishop(source);
        Cell[] res = bishop.way(dist);
        Cell[] ex = new Cell[] {new Cell(2, 1), new Cell(3, 2), new Cell(4, 3)};
        String result = String.valueOf(res[0].getX() + res[0].getY() + res[1].getX() + res[1].getY() + res[2].getX() + res[2].getY());
        String expect = String.valueOf(ex[0].getX() + ex[0].getY() + ex[1].getX() + ex[1].getY() + ex[2].getX() + ex[2].getY());
        //System.out.println(res[1].getX() == ex[1].getX());
        assertThat(expect, is(result));
    }

    /**
     * Test.
     */
    @Test
    public void wayTest2() {
        Cell source = new Cell(5, 4);
        Cell dist = new Cell(2, 7);
        Bishop bishop = new Bishop(source);
        Cell[] res = bishop.way(dist);
        Cell[] ex = new Cell[] {new Cell(2, 7), new Cell(3, 6), new Cell(4, 5)};
        String result = String.valueOf(res[0].getX() + res[0].getY() + res[1].getX() + res[1].getY() + res[2].getX() + res[2].getY());
        String expect = String.valueOf(ex[0].getX() + ex[0].getY() + ex[1].getX() + ex[1].getY() + ex[2].getX() + ex[2].getY());
        //System.out.println(res[1].getX() == ex[1].getX());
        assertThat(expect, is(result));
    }

    /**
     * Test.
     */
    @Test
    public void wayTest3() {
        Cell source = new Cell(5, 4);
        Cell dist = new Cell(8, 7);
        Bishop bishop = new Bishop(source);
        Cell[] res = bishop.way(dist);
        Cell[] ex = new Cell[] {new Cell(8, 7), new Cell(7, 6), new Cell(6, 5)};
        String result = String.valueOf(res[0].getX() + res[0].getY() + res[1].getX() + res[1].getY() + res[2].getX() + res[2].getY());
        String expect = String.valueOf(ex[0].getX() + ex[0].getY() + ex[1].getX() + ex[1].getY() + ex[2].getX() + ex[2].getY());
        //System.out.println(res[1].getX() == ex[1].getX());
        assertThat(expect, is(result));
    }

    /**
     * Test.
     */
    @Test
    public void wayTest4() {
        Cell source = new Cell(5, 4);
        Cell dist = new Cell(8, 1);
        Bishop bishop = new Bishop(source);
        Cell[] res = bishop.way(dist);
        Cell[] ex = new Cell[] {new Cell(8, 1), new Cell(7, 2), new Cell(6, 3)};
        String result = String.valueOf(res[0].getX() + res[0].getY() + res[1].getX() + res[1].getY() + res[2].getX() + res[2].getY());
        String expect = String.valueOf(ex[0].getX() + ex[0].getY() + ex[1].getX() + ex[1].getY() + ex[2].getX() + ex[2].getY());
        //System.out.println(res[1].getX() == ex[1].getX());
        assertThat(expect, is(result));
    }
}
