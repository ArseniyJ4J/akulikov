package ru.job4j.sql.tracker;

/** Абстрактный класс BaseAction.
 * @author Arseniy Kulkiov
 * @since 13.07.2017
 * @version 1
 */

public abstract class BaseAction implements UserAction {
    /**
     * key - ключ действия.
     */
    private int key;
    /**
     * name - имя действия.
     */
    private String name;
    /**
     * Конструктор.
     * @param key - ключ действия.
     * @param name - имя действия.
     */
    public BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }
    /**
     * Метод возврата значения ключа.
     * @return - возврат.
     */
        public int key() {
        return this.key;
        }
    /**
     * Метод выполнения добавления заявки.
     * @param input - ввод.
     * @param tracker - трекер.
     */
        public void execute(Input input, Tracker tracker) {
        }
    /**
     * Метод возвращающий строку для отображения в меню.
     * @return - возврат.
     */
        public String info() {
            return String.format("%s. %s", this.key(), name);
        }
    }

