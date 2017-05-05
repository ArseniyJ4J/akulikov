package ru.job4j.loop;
/**
* Class Класс рисования пирамиды в псевдорафике.
* @author akulikov
* @since 05.05.2017
* @version 1
*/
public class Paint {
	/**
	* Метод выполняющий построение "пирамиды".
	* @param h - высота пирамиды.
	* @return - возвращение.
	*/
	public String piramid(int h) {
		int w = h * 2 - 1;
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i <= h; i++) {
				int p = h - i;
				int z = w - p * 2;
				for (int i2 = 0; i2 < p; i2++) {
					builder.append(" ");
				}
				for (int i3 = 0; i3 < z; i3++) {
					builder.append("^");
				}
		builder.append(System.getProperty("line.separator"));
		}
	return builder.toString();
	}
}