package ru.job4j.tracker;

import static java.lang.Integer.parseInt;

/** Class Класс StartUI.
 * @author Arseniy Kulkiov
 * @since 20.06.2017
 * @version 1
 */

public class StartUi {
    /**
     * input - ввод.
     */
    private Input input;
    /**
     * tracker - трекер.
     */
    private Tracker tracker = new Tracker();
    /**
     * Конструктор.
     * @param input - ввод.
     * @param tracker - трекер.
     */
    public StartUi(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }
    /**
     * Конструктор.
     * @param input - ввод.
     */
    public StartUi(Input input) {
        this.input = input;
    }
    /**
     * Метод инициализатор метода main.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillAction();
        do {
            menu.show();
            int key = parseInt(input.ask("Select:"));
            if (key == 6) {
                break;
            }
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit?(y/n): ")));
    }
    /**
     * Метод main.
     * @param args - строки из консоли.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUi(input).init();

    }
}
