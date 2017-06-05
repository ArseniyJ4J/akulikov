package ru.job4j.tracker;

import java.util.Random;

/** Class Tracker.
 * @author Arseniy Kulkiov
 * @since 05.06.2017
 * @version 1
 */
public class Tracker {
    /**
     * Создание объекта Item в поле класса.
     * @param items - массив items (заявок).
     * @param position - номер позиции добавляемой заявки в списке заявок.
     */
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();
    /**
     * Метод добавления заявки.
     * @return - возвращение.
     * @param item - заявка.
     */
    public Item add(Item item) {
        item.setId(String.valueOf(RN.nextInt()));
        this.items[position++] = item;
        return item;
    }
    /**
     * Метод редактирования заявки.
     * @param item - заявка.
     */
    public void update (Item item) {
    }
    /**
     * Метод удаления заявки.
     * @param item - заявка.
     */
    public void delete (Item item) {
    }
    /**
     * Метод получения списка всех заявок.
     */
    public Item[] findAll() {
        return Item[0];
    }
    /**
     * Метод получения списка заявок по имени.
     * @param key - имя заявки попадающей в получаемый список.
     */
    public Item[] findByName(String key) {
        return Item[0];
    }
    /**
     * Метод получения заявки по id.
     * @param id - id(идентификатор) заявки.
     */
    public Item findById(String id){
        Item result = null;
        for (Item item : items) {
            if (item != null && item.GetId.equals(id)){
                result = item;
                break;
            }
        }
        return result;
    }

}
