package ru.job4j.sql.tracker;

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
    /**
     * Метод ввода данных с консоли.
     * @return - возврат значения.
     * @param question - вопрос.
     * @param range - массив с диапазоном возможных вариантов выбора меню.
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                int key = Integer.valueOf(this.answers[position++]);
                boolean exist = false;
                for (int point : range) {
                    if (point == key) {
                        exist = true;
                        break;
                    }
                }
                if (exist) {
                    value = key;
                } else {
                    throw new MenuOutException("Out of menu range.");
                }
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        }
        while (invalid);
        return value;
        //throw new UnsupportedOperationException("Unsupported operation");
        //return Integer.parseInt(answers[position++]);
    }

}
