package ru.job4j.multithreading.waitnotify.threadpool;

/**
 * StartUI Class.
 * @author Arseniy Kulikov.
 * @since 08.11.2017.
 * @version 1.
 */
public class StartUI {

    /**
     * Метод main.
     * @param args - параметр.
     */
    public static void main(String[] args) {
        int coreNum = Runtime.getRuntime().availableProcessors();
        ThreadPool tp = new ThreadPool(coreNum);
        for (int i = 0; i < 300; i++) {
            Work work = new Work(i);
            tp.add(work);
        }
        tp.finish();
    }
}
