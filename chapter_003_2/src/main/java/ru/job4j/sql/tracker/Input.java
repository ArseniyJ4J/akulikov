package ru.job4j.sql.tracker;
/** Интерфейс ввода.
 * @author Arseniy Kulkiov
 * @since 20.06.2017
 * @version 1
 */
public interface Input {
    /**
     * Метод вопрос - ответ.
     * @param question - вопрос.
     * @return - возврат значения.
     */
    String ask(String question);
    /**
     * Метод вопрос - ответ.
     * @param question - вопрос.
     * @param range - массив с диапазоном возможных вариантов выбора меню.
     * @return - возврат значения.
     */
    int ask(String question, int[] range);
}
