package ru.job4j;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Arseniy Kulikov (mailto:arsmil424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class CalculateTest {
	/**
	* Test add.
	*/
	@Test
	public void whenAddOneToOneThenTwo() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Calculate.main(null);
		assertThat(
			out.toString(),
			is(
				String.format(
				"Hello world!%s",
					System.getProperty("line.separator")
				)
			)
		);
	}
}