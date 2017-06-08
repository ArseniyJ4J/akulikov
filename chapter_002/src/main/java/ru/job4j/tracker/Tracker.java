package ru.job4j.tracker;

import java.util.Random;

/** Class tracker.
 * @author Arseniy Kulkiov
 * @since 05.06.2017
 * @version 1
 */
public class Tracker {
    /**
     * @param items - массив items (заявок).
     * @param position - номер позиции добавляемой заявки в списке заявок.
     * @param RN - случайное число.
     */
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();
    /**
     * Метод возвращающий массив заявок.
     * @return - возвращение.
     */
    public Item[] getItems(){
        return this.items;
    }
    /**
     * Метод добавления заявки.
     * @return - возвращение.
     * @param item - заявка.
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }
    /**
     * Метод редактирования заявки.
     * @param item - заявка.
     */
    public void update (Item item) {
        int i = this.indexFromId(item);
        this.items[i] = item;

        //for (int i = 0; i != this.position; i++) {
        //    if (this.items[i] != null && this.items[i].getId.equals(item.getId)){
        //        this.items[i] = item;
        //        break;
        //    }
        //}
    }
    /**
     * Метод удаления заявки.
     * @param item - заявка.
     */
    public void delete (Item item) {
        int i = this.indexFromId(item);
        System.arraycopy(this.items, i + 1, this.items, i, this.position - i);
        this.position--;

        //int i = this.indexFromId(item);
        //Item[] b = new Item[this.items.length];
        //System.arraycopy(this.items, 0, b, 0, i);
        //System.arraycopy(this.items, i + 1, b, i, this.items.length - i + 1);
        //this.items = b;
    }
    /**
     * Метод получения списка всех заявок.
     * @return - возвращение.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
    /**
     * Метод получения списка заявок по имени.
     * @return - возвращение.
     * @param key - имя заявки попадающей в получаемый список.
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int index = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)){
                result[index] = item;
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
    public Item findById(String id){
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)){
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
    String generateId(){
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
    /**
     * Метод возвращающий индекс в массиве по id.
     * @return - возвращаемое значение.
     */
    public int indexFromId (Item item) {
        int index;
        for (index = 0; index < this.items.length; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(item.getId())){
                break;
            }
        }
        return index;
    }
}
