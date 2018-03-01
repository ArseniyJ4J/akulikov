package ru.job4j.sql.tracker;

/** Class Класс StartUI.
 * @author Arseniy Kulkiov
 * @since 20.06.2017
 * @version 1
 */

public class StartUi {
    /**
     * @param ranges - массив с диапазоном возможных вариантов выбора меню.
     */
    private int[] ranges = new int[7];
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
        for (int i = 0; i < menu.getActions().size(); i++) {
            ranges[i] = menu.getActions().get(i).key();
        }
        do {
            menu.show();
            int call = input.ask("Select: ", ranges);
            if (call == 6) {
                break;
            } else {
                menu.select(call);
            }
        } while (!"y".equals(this.input.ask("Exit?(y/n): ")));
    }
    /**
     * Метод main.
     * @param args - строки из консоли.
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUi(input).init();

    }
}
