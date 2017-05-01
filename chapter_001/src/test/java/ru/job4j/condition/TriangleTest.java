package ru.job4j.condition;

import org.junit.Test;

//import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
/**
* Test for Tringle.
*
* @author Arseniy Kulikov (mailto:arsmail424@gmail.com)
* @version 1.0
* @since 1.0
*/
public class TriangleTest {
	/**
	* Test.
	*/
	@Test
	public void areaOfTriangle() {
		Point z = new Point(2, -3);
		Point j = new Point(1, 1);
		Point s = new Point(-6, 6);
		//Triangle triang = new Triangle(new Point(2, -3), new Point(1, 1), new Point(-6, 6));
		Triangle triang = new Triangle(z, j, s);
		double result = triang.area();
		double except = 11.50;
		assertThat(result, closeTo(except, 0.05));
	}
}