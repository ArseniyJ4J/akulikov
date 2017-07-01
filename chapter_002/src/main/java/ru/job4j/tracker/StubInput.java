package ru.job4j.tracker;

/** Class Класс StubInput.
 * @author Arseniy Kulkiov
 * @since 23.06.2017
 * @version 1
 */

public class StubInput implements Input {
    /**
     * Массив ответов.
     */
    private String[] answers;
    /**
     * Счетчик положения в меню.
     */
    private int position = 0;
    /**
     * Метод.
     * @param answers - ответы
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    /**
     * Метод ввода данных с консоли.
     * @return - возврат значения.
     * @param question - вопрос.
     */
    public String ask(String question) {
        return answers[position++];
    }

}
