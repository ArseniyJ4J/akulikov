package ru.job4j.collections.tracker;

/** Интерфейс UserAction.
 * @author Arseniy Kulkiov
 * @since 02.07.2017
 * @version 1
 */

public interface UserAction {
    /**
     * Ключ.
     * @return - возврат
     */
    int key();
    /**
     * Выполнение действия.
     * @param input - ввод.
     * @param tracker - трекер.
     */
    void execute(Input input, Tracker tracker);
    /**
     * Описание действия.
     * @return - возврат
     */
    String info();
}
