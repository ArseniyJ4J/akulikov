package ru.job4j.multithreading.bomberman;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Arseniy Kulkiov
 */
public class BomberManTest {

    @Test
    public void moveTest() {
        BomberMan bm = new BomberMan(5, 5, 10, 10);
        for (int i = 0; i < 50; i++) {
            System.out.print(i + "iteration: ");
            if (!bm.move()) {
             i--;
            }
        }
    }

    @Test
    public void moveTest2() {
        ReentrantLock[][] rl = new ReentrantLock[10][10];
        BomberMan bm = new BomberMan(5, 5, rl);
        for (int i = 0; i < 50; i++) {
            System.out.print(i + "iteration: ");
            if (!bm.move()) {
                i--;
            }
        }
    }

    @Test
    public void test() {
        ReentrantLock[][] rl = new ReentrantLock[10][10];
        Thread thread1 = new Thread(new BomberMan(5, 5, rl));
//        Thread thread2 = new Thread(new BomberMan(6, 6, rl));
        thread1.start();
//        thread2.start();
    }

}