package ru.job4j.sql.tracker;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Class tracker.
 * @author Arseniy Kulkiov
 * @since 05.06.2017
 * @version 1
 */
public class Tracker {
    /**
     * items - массив items (заявок).
     */
    private List<Item> items = new ArrayList<>();
    /**
     * position - номер позиции добавляемой заявки в списке заявок.
     */
    private int position = 0;
    /**
     * RN - случайное число.
     */
    private static final Random RN = new Random();
    /**
     * Метод возвращающий массив заявок.
     * @return - возвращение.
     */
    public List<Item> getItems() {
        return this.items;
    }
    /**
     * Метод добавления заявки.
     * @return - возвращение.
     * @param item - заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(position, item);
        position++;
        return item;
    }
    /**
     * Метод редактирования заявки.
     * @param item - заявка.
     * @return - возвращение.
     */
    public boolean update(Item item) {
        boolean result = false;
        int i = this.items.indexOf(item);
        if (i != -1) {
            this.items.set(i, item);
            result = true;
        }
        return result;
    }
    /**
     * Метод удаления заявки.
     * @param item - заявка.
     * @return - возвращение.

     */
    public boolean delete(Item item) {
        boolean result = false;
        int i = this.items.indexOf(item);
        if (i != -1) {
            this.items.remove(i);
            this.position--;
            result = true;
        }
        return result;
    }
    /**
     * Метод получения списка всех заявок.
     * @return - возвращение.
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        for (int index = 0; index != this.position; index++) {
            result.add(index, this.items.get(index));
        }
        return result;
    }
    /**
     * Метод получения списка заявок по имени.
     * @return - возвращение.
     * @param key - имя заявки попадающей в получаемый список.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        int index = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                result.add(index, item);
                index++;
            }
        }
        return result;
    }
    /**
     * Метод получения заявки по id.
     * @return - возвращение.
     * @param id - id(идентификатор) заявки.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
    /**
     * Метод генерации id.
     * @return - возвращаемое значение.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Метод возвращающий индекс в массиве по id.
     * @return - возвращаемое значение.
     * @param item - заявка.
     */
    public int indexFromId(Item item) {
        int result = -1;
        for (int index = 0; index < this.items.size() - 1; index++) {
            if (this.items.get(index) != null && this.items.get(index).getId().equals(item.getId())) {
                result = index;
                break;
            }
        }
        return result;
    }
}
