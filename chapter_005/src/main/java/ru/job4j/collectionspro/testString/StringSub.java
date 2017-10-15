package ru.job4j.collectionspro.testString;

/**
 * StringSub Class.
 * @author Arseniy Kulikov.
 * @since 15.10.2017.
 * @version 1.
 */
public class StringSub {

    /**
     * Метод сравнивающий две строки на равенство символов из которых они состоят.
     * @param a - первая строка.
     * @param b - вторая строка.
     * @return - возврат значения.
     */
    public boolean compareString(String a, String b) {
        return this.hashCode(a) == this.hashCode(b);
    }

    /**
     * Хэш-функция.
     * @param s - строка.
     * @return - возврат значения.
     */
    private int hashCode(String s) {
        char[] buffer = s.toCharArray();
        int result = 0;
        for (int i = 0; i < buffer.length; i++) {
                Character value = buffer[i];
                result = result + value.hashCode();
        }
        return result * buffer.length;
    }
}
