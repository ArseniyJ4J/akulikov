package ru.job4j.multithreading.waitnotify.threadpool;

import java.util.ArrayList;
import java.util.List;

/**
 * ThreadPool Class.
 * @author Arseniy Kulikov.
 * @since 08.11.2017.
 * @version 1.
 */
public class ThreadPool {

    /**
     * Поле класса.
     */
    private boolean finish = true;

    /**
     * Поле класса.
     */
    List<Thread> threads = new ArrayList<>();

    /**
     * Поле класса.
     */
    BlockingQueue<Runnable> works = new BlockingQueue<>(15);

    /**
     * Конструктор.
     * @param coreNum - количество ядер процессора.
     */
    public ThreadPool(int coreNum) {
        for (int i = 0; i < coreNum; i++) {
            Thread thread = new Thread(new RunWorker());
            thread.start();
            threads.add(thread);
        }
    }

    /**
     * Метод добавления какой-то работы.
     * @param work - какая-то работа.
     */
    public void add(Runnable work) {
        try {
            works.put(work);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод запускающий процесс завершения программы.
     */
    public synchronized void finish() {
        this.finish = false;
    }

    /**
     * Внутренний клас RunWorker.
     */
    public class RunWorker implements Runnable {

        @Override
        public void run() {
            while (finish || works.size() > 0) {
                try {
                    works.take().run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
