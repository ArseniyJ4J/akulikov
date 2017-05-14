package ru.job4j.array;

//import java.unit.Arrays;
/**
* Class Search sub string in origin string.
* @author akulikov
* @since 12.05.2017
* @version 1
*/
public class SubString {
	/**
	* Метод определяющий наличие одного набора символов строки в другой строке.
	* @param origin - исходная строка.
	* @param sub - cубстрока.
	* @return - возвращение.
	*/
	public boolean contains(String origin, String sub) {
	char[] orAr = origin.toCharArray();
	char[] subAr = sub.toCharArray();
	boolean result = false;
		// hu ton
		for (int i = 0; i < orAr.length; i++) {
			int total = 0;
			for (int s = 0; s < subAr.length; s++) {
				if ((i + s) >= orAr.length) {
				break;
				}
				if (orAr[i + s] == subAr[s]) {
				total++;
				} else {
					break;
				}
			}
			if (total == subAr.length) {
				result = true;
				break;
			}
		}
		return result;
	}
}