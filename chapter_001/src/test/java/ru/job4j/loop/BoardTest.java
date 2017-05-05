package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Test for Board.
*
* @author Arseniy Kulkiov (mailto:arsmail424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class BoardTest {
	/**
	* Test.
	*/
	@Test
	public void whenThreeColAndThreeRows() {
		Board board = new Board();
		String result = board.paint(3, 3);
		final String line = System.getProperty("line.separator");
		String expected = String.format("x x%s x %sx x%s", line, line, line);
		assertThat(result, is(expected));
	}
	/**
	* Test.
	*/
	@Test
	public void whenFiveColAndFourRows() {
		Board board = new Board();
		String result = board.paint(5, 4);
		final String line = System.getProperty("line.separator");
		String expected = String.format("x x x%s x x %sx x x%s x x %s", line, line, line, line);
		assertThat(result, is(expected));
	}
}