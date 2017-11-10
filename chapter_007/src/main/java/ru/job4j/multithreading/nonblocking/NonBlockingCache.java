package ru.job4j.multithreading.nonblocking;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * NonBlockingCache Class.
 * @author Arseniy Kulikov.
 * @since 10.11.2017.
 * @version 1.
 * @param <E> - параметризованный тип.
 */
public class NonBlockingCache<E extends User> {


    /**
     * Контейнер для моделей.
     */
    private ConcurrentHashMap<Integer, E> map = new ConcurrentHashMap<>();

    /**
     * Метод возвращающий размер контейнера.
     * @return - возврат значения.
     */
    public int size() {
        return map.size();
    }

    /**
     * Метод получения модели по ключу.
     * @param key - ключ.
     * @return - возврат значения.
     */
    public E get(int key) {
        return map.get(key);
    }

    /**
     * Метод добавления модели в контейнер.
     * @param model - модель.
     */
    public void add(User model) {
        this.map.putIfAbsent(model.getKey(), (E) model);
    }

    /**
     * Метод удаления элемента по ключу.
     * @param key - ключ.
     */
    public void remove(int key) {
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        } else {
            System.out.println("There is no such element.");
        }
    }

    /**
     * Метод обновления элемента контейнера.
     * @param model - обновленный элемент.
     */
    public void update(User model) {
        this.map.computeIfPresent(model.getKey(), new BiFunction<Integer, E, E>() {
            @Override
            public E apply(Integer integer, E element) {
                if (model.getVersion() == element.getVersion()) {
                    element.setValue(model.getValue());
                } else {
                    try {
                        throw new OplimisticException("There is no such element.");
                    } catch (OplimisticException exception) {
                        exception.printStackTrace();
                    }
                }
                return element;
            }
        });
    }
}