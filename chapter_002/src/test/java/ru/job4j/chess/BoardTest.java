package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.figures.Bishop;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/** Тест-класс BoardTest.
 * @author Arseniy Kulkiov
 * @since 25.07.2017
 * @version 1
 */
public class BoardTest {

    /**
     * Test.
     */
    @Test
    public void moveTest() {
        Board board = new Board();
        Cell source = new Cell(5, 4);
        Bishop bishop = new Bishop(source);
        board.getFigures()[5] = bishop;
        Cell dist = new Cell(3, 2);
        boolean bResult = board.move(source, dist);
        boolean bExpext = true;
        assertThat(bExpext, is(bResult));
    }
}
