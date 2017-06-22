package ru.job4j.tracker;

import java.util.Scanner;
/** Class Класс пользовательского ввода в консоли.
 * @author Arseniy Kulkiov
 * @since 20.06.2017
 * @version 1
 */
public class ConsoleInput implements Input {
    /**
     * Объявление поля.
     * @param Scanner - сканер.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Метод ввода данных с консоли.
     * @return - возврат значения.
     * @param question - вопрос.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

}
