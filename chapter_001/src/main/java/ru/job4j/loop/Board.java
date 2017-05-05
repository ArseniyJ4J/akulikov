package ru.job4j.loop;
/**
* Class Класс построения шахматной доски.
* @author akulikov
* @since 04.05.2017
* @version 1
*/
public class Board {
	/**
	* Метод выполняющий построение "шахматной доски".
	* @param widht - ширина доски.
	* @param height - высота доски.
	* @return - возвращение.
	*/
	public String paint(int widht, int height) {
		StringBuilder builder = new StringBuilder();
		for (int index = 0; index < height; index++) {
			for (int index2 = 0 + index; index2 < widht + index; index2++) {
				if (index2 % 2 == 0) {
					builder.append("x");
				} else {
					builder.append(" ");
				}
			}
			builder.append(System.getProperty("line.separator"));
		}
		return builder.toString();
	}
}