package ru.job4j.multithreading.bomberman;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Arseniy Kulkiov
 */
public class BomberManSecond implements Runnable {
    /**
     * Class field.
     */
    ReentrantLock[][] board;
    /**
     * Class field.
     */
    Random random = new Random();
    /**
     * Class field.
     */
    int posX;
    /**
     * Class field.
     */
    int posY;
    /**
     * Class field.
     */
    String name;



    /**
     * Constructor.
     * @param posX - X coordinate.
     * @param posY - Y coordinate.
     * @param board - board.
     */
    public BomberManSecond(int posX, int posY, ReentrantLock[][] board) {
        if (!this.configurationRightCheck(posX, posY, board)) {
            System.out.println("Wrong configuration of Bomberman!");
        }
        String postfix;
        if (posY > 5) {
            postfix = "SECOND:       ";
        } else {
            postfix = "FIRST:        ";
        }
        this.name = String.format("%s", postfix);
        this.posX = posX;
        this.posY = posY;
        this.board = board;
    }

    /**
     * Method.
     * @param posX - posX.
     * @param posY - posY.
     * @param board - board.
     * @return - return statement.
     */
    private boolean configurationRightCheck(int posX, int posY, ReentrantLock[][] board) {
        boolean result = true;
        int lenght = board.length;
        if (posX > lenght - 1 || posX < 0 || posY > lenght - 1 || posY < 0) {
            result = false;
            System.out.printf("%s:                        Неверный диапазон!\n", this.name);
        }
        return result;
    }

    /**
     * Move method.
     * @return - return statement.
     */
    public boolean move() {
        boolean result = false;
        boolean check1 = random.nextBoolean();
        int x = this.posX;
        int y = this.posY;
        System.out.printf("%s:          from X[%s]Y[%s] \n", this.name, x, y);
        if (check1) {
            System.out.printf("%s: X ", this.name);
            boolean check2 = random.nextBoolean();
            if (check2) {
                System.out.printf("on RIGHT to X[%s]Y[%s] \n", x + 1, y);
                x++;
            } else {
                System.out.printf("on LEFT to  X[%s]Y[%s] \n", x - 1, y);
                x--;
            }
        } else {
            boolean check2 = random.nextBoolean();
            System.out.printf("%s: Y ", this.name);
            if (check2) {
                System.out.printf("on UP to    X[%s]Y[%s] \n", x, y + 1);
                y++;
            } else {
                System.out.printf("on DOWN to  X[%s]Y[%s] \n", x, y - 1);
                y--;
            }
        }
        if (this.configurationRightCheck(x, y, this.board)) {
            try {
                boolean check = false;
                check = this.board[x][y].tryLock(500, TimeUnit.MILLISECONDS);
                if (!check) {
                    System.out.printf("%s: Первая попытка, клетка ЗАНЯТА!\n", this.name);
                    check = this.board[x][y].tryLock();
                    if (!check) {
                        System.out.printf("%s: Вторая попытка после 500мс, Клетка все равно занята, ухожу на повторный .move()\n", this.name);
                        this.move();
                    }
                } else if (check) {
                    this.board[this.posX][this.posY].unlock();
                    this.posX = x;
                    this.posY = y;
                    result = true;
                    System.out.printf("%s: Ход сделан!\n", this.name);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            if (this.board[x][y].tryLock()) {
//                this.board[this.posX][this.posY].unlock();
//                this.posX = x;
//                this.posY = y;
//                result = true;
//                System.out.println("Ход сделан!");
//            } else {
//                try {
//                    System.out.println("ЗАБЛОКИРОВАННО!!!!!!!!");
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                this.move();
//            }
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
