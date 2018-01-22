package ru.job4j.multithreading.bomberman;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Arseniy Kulkiov
 */
public class BomberMan implements Runnable {
    /**
     * Field of class.
     */
    ReentrantLock[][] board;
    /**
     * Field of class.
     */
    int positionX;
    /**
     * Field of class.
     */
    int positionY;
    /**
     * Field of class.
     */
    int fieldX;
    /**
     * Field of class.
     */
    int fieldY;
    /**
     * Field of class.
     */
    Random random = new Random();

    /**
     * Constructor.
     * @param positionX - X coordinate.
     * @param positionY - Y coordinate.
     * @param board - board.
     */
    public BomberMan(int positionX, int positionY, ReentrantLock[][] board) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.fieldX = board.length;
        this.fieldY = board.length;
        this.board = board;
        if (!this.configurationRightCheck(positionX, positionY, this.fieldX, this.fieldY)) {
            System.out.println("Wrong configuration!");
        }
        this.board[this.positionX][this.positionY] = new ReentrantLock();
        this.board[this.positionX][this.positionY].lock();
    }

    /**
     * Constructor.
     * @param positionX - X coordinate.
     * @param positionY - Y coordinate.
     * @param fieldX - limit X.
     * @param fieldY - limit Y.
     */
    public BomberMan(int positionX, int positionY, int fieldX, int fieldY) {
//        this.board = board;
        if (!this.configurationRightCheck(positionX, positionY, fieldX, fieldY)) {
            System.out.println("Wrong configuration!");
        }
        this.positionX = positionX;
        this.positionY = positionY;
        this.fieldX = fieldX;
        this.fieldY = fieldY;
        this.board = new ReentrantLock[fieldX][fieldY];
        this.board[this.positionX][this.positionY] = new ReentrantLock();
        this.board[this.positionX][this.positionY].lock();
    }

    /**
     * Метод проверки допустимости координат.
     * @param positionX - X coordinate.
     * @param positionY - Y coordinate.
     * @param fieldX - limit X.
     * @param fieldY - limit Y.
     * @return - возврат значения.
     */
    private boolean configurationRightCheck(int positionX, int positionY, int fieldX, int fieldY) {
        boolean result = true;
        if (fieldX <= 0 || fieldY <= 0 || positionX > fieldX - 1 || positionX < 0 || positionY > fieldY - 1 || positionY < 0) {
            result = false;
        }
        return result;
    }

    /**
     * Проверка допустимости перемещения.
     * @param positionX - X coordinate.
     * @param positionY - Y coordinate.
     * @return - возврат значения.
     */
    private boolean moveRightCheck(int positionX, int positionY) {
        boolean result = false;
        if (this.configurationRightCheck(positionX, positionY, this.fieldX, this.fieldY)) {
            if (this.board[positionX][positionY] == null) {
                this.board[positionX][positionY] = new ReentrantLock();
                this.board[positionX][positionY].lock();
                result = true;
            } else {
                try {
                    result = this.board[positionX][positionY].tryLock(500, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
//        if (this.board[positionX][positionY] == null) {
//            this.board[positionX][positionY] = new ReentrantLock();
//        }
//        return this.configurationRightCheck(positionX, positionY, this.fieldX, this.fieldY) && this.board[positionX][positionY].tryLock();
        return result;
    }

    /**
     * Move method.
     * @return - возврат значения.
     */
    public boolean move() {
        boolean result = false;
        boolean check1 = random.nextBoolean();
//        System.out.println("check1 = " + check1 + ".");
        int x = this.positionX;
        int y = this.positionY;
        if (check1) {
            System.out.print("X:");
            boolean check2 = random.nextBoolean();
//            System.out.println("check2 = " + check2 + ".");
            if (check2) {
                System.out.println(" RIGHT.");
                x++;
            } else {
                System.out.println(" LEFT.");
                x--;
            }
//            this.positionX = random.nextBoolean() ? this.positionX++ : this.positionX--;
        } else {
            boolean check2 = random.nextBoolean();
//            System.out.println("check2 = " + check2 + ".");
            System.out.print("Y:");
            if (check2) {
                System.out.println(" UP.");
                y++;
            } else {
                System.out.println(" DOWN.");
                y--;
            }
//            this.positionY = random.nextBoolean() ? this.positionY++ : this.positionY--;
        }
        if (this.moveRightCheck(x, y)) {
            int bufX = this.positionX;
            int bufY = this.positionY;
//            this.board[this.positionX][this.positionY].unlock();
            this.positionX = x;
            this.positionY = y;
            this.board[this.positionX][this.positionY].lock();
            System.out.println(this.board[bufX][bufY].isLocked());
            this.board[bufX][bufY].unlock();
            System.out.println(this.board[bufX][bufY].isLocked());

            result = true;
        }
        System.out.printf("X: %s, Y: %s.%n", this.positionX, this.positionY);
        return result;
    }

    @Override
    public void run() {
        System.out.println("ALOHA!");
//        while (true) {
//            this.move();
//        }
        for (int i = 0; i < 5; i++) {
            System.out.print(i + "iteration: ");
            if (!this.move()) {
                i--;
            }
        }
    }
}
