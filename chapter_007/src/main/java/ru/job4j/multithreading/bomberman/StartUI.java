package ru.job4j.multithreading.bomberman;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Arseniy Kulkiov
 */
public class StartUI {
    /**
     * Main method.
     * @param args - comand line parametres.
     */
    public static void main(String[] args) {
        ReentrantLock[][] rl;
        rl = initialBoard(10);
        BomberManSecond bm = new BomberManSecond(5, 5, rl);
        BomberManSecond bm2 = new BomberManSecond(5, 6, rl);
        Thread thread1 = new Thread(bm);
        Thread thread2 = new Thread(bm2);
        thread1.start();
        thread2.start();
//        System.out.println(rl[5][5].isLocked());
//        rl[4][5].lock();
//        System.out.println(rl[4][5].isLocked());
//        rl[4][5].unlock();
//        System.out.println(rl[4][5].isLocked());
//        BomberMan bm1 = new BomberMan(5, 5, rl);
////        BomberMan bm2 = new BomberMan(6, 6, rl);
//        Thread thread1 = new Thread(bm1);
////        Thread thread2 = new Thread(bm2);
//        thread1.start();
////        thread2.start();
//
//
////        for (int i = 0; i < 50; i++) {
////            System.out.print(i + "iteration: ");
////            if (!bm1.move()) {
////                i--;
////            }
////        }
    }

    /**
     * Initial board method.
     * @param size - board's size.
     * @return - return statement.
     */
    private static ReentrantLock[][] initialBoard(int size) {
        ReentrantLock[][] rl = new ReentrantLock[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rl[i][j] = new ReentrantLock();
            }
        }
        return rl;
    }

}
