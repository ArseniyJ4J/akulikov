package ru.job4j.collectionspro.generic.store;

import ru.job4j.collectionspro.generic.SimpleArray;

/** Класс UserStore.
 * @author Arseniy Kulkiov
 * @since 21.08.2017
 * @version 1
 * @param <T> - параметризованный тип.
 */

public class UserStore<T extends User> implements Store<T> {
    /**
     * Поле класса.
     */
    private SimpleArray<T> sa;
    /**
     * Поле класса.
     */
    private int size;
    /**
     * Конструктор.
     * @param size - размер хранилища.
     */
    public UserStore(int size) {
        this.sa = new SimpleArray<T>(size);
        this.size = size;
    }
    /**
     * Геттер для поля класса sa(хранилища).
     * @return - возврат значения.
     */
    public SimpleArray<T> getSa() {
        return sa;
    }
    /**
     * Метод добавления.
     * @param value - добавляемый объект.
     */
    @Override
    public void add(T value) {
        this.sa.add(value);
    }
    /**
     * Метод обновления.
     * @param value - обновляемый объект.
     */
    @Override
    public void update(T value) {
        for (int i = 0; i < this.size; i++) {
            if (this.sa.get(i).getId().equals(value.getId())) {
                this.sa.update(value, i);
                break;
            }
        }
    }
    /**
     * Метод удаления.
     * @param value - удаляемый объект.
     */
    @Override
    public void remove(T value) {
        this.sa.delete(value);
    }
}
