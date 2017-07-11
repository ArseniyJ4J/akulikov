package ru.job4j.tracker;

/** Class Класс ValidateInput.
 * @author Arseniy Kulkiov
 * @since 10.07.2017
 * @version 1
 */

public class ValidateInput extends ConsoleInput {
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
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu.");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        }
        while (invalid);
        return value;
    }
}
