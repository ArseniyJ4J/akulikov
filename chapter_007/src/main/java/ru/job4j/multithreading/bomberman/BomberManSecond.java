package ru.job4j.multithreading.bomberman;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Arseniy Kulkiov
 */
public class BomberManSecond implements Runnable {

    ReentrantLock[][] board;

    Random random = new Random();

    int posX;

    int posY;

    public BomberManSecond(int posX, int posY, ReentrantLock[][] board) {
        if (!this.configurationRightCheck(posX, posY, board)) {
            System.out.println("Wrong configuration of Bomberman!");
        }
        this.posX = posX;
        this.posY = posY;
        this.board = board;
    }

    private boolean configurationRightCheck(int posX, int posY, ReentrantLock[][] board) {
        boolean result = true;
        int lenght = board.length;
        if (posX > lenght - 1 || posX < 0 || posY > lenght - 1 || posY < 0) {
            result = false;
        }
        return result;
    }

    public boolean move() {
        boolean result = false;
        boolean check1 = random.nextBoolean();
        int x = this.posX;
        int y = this.posY;
        if (check1) {
            System.out.print("X:");
            boolean check2 = random.nextBoolean();
            if (check2) {
                System.out.println(" RIGHT.");
                x++;
            } else {
                System.out.println(" LEFT.");
                x--;
            }
        } else {
            boolean check2 = random.nextBoolean();
            System.out.print("Y:");
            if (check2) {
                System.out.println(" UP.");
                y++;
            } else {
                System.out.println(" DOWN.");
                y--;
            }
        }
        if (this.configurationRightCheck(x, y, this.board)) {
            if (this.board[x][y].tryLock()) {
                this.board[this.posX][this.posY].unlock();
                this.posX = x;
                this.posY = y;
                result = true;
                System.out.println("Ход сделан!");
            } else {
                try {
                    System.out.println("ЗАБЛОКИРОВАННО!!!!!!!!");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.move();
            }
        }
        return result;
    }

    @Override
    public void run() {
        if (this.board[posX][posY].tryLock()) {
            System.out.println("При создании bombermana лок встал нормально!");
        } else {
            System.out.println("При создании bombermana лок НЕ ВСТАЛ!!!");
        }
        for (int i = 0; i < 500; i++) {
            this.move();
        }
    }
}
