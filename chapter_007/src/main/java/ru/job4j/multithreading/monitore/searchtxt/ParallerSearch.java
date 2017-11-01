package ru.job4j.multithreading.monitore.searchtxt;

import java.util.ArrayList;
import java.util.List;

/**
 * ParallerSearch Class.
 * @author Arseniy Kulikov.
 * @since 01.11.2017.
 * @version 1.
 */
public class ParallerSearch {

    /**
     * Поле класса.
     */
    private String root;

    /**
     * Поле класса.
     */
    private String text;

    /**
     * Поле класса.
     */
    private List<String> exts;

    /**
     * Поле класса.
     */
    private BlockingQueue<String> filePaths = new BlockingQueue<>(5);

    /**
     * Поле класса.
     */
    private List<String> result = new ArrayList<>();

    /**
     * Конструктор.
     * @param root - корень.
     * @param text - искомый текст.
     * @param exts - список расширений файлов для поиска.
     */
    public ParallerSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;
    }

    /**
     * Метод start.
     */
    public void start() {
        System.out.println("Start programm...");
        System.out.println("=================");
        FileSearch fs = new FileSearch(this.root, this.exts, filePaths);
        Thread fileSearchThread = new Thread(fs);
        fileSearchThread.start();
        TxtSearch ts = new TxtSearch(result, filePaths, text);
        Thread textSearchThread = new Thread(ts);
        textSearchThread.start();
        try {
            fileSearchThread.join();
            textSearchThread.join();
            System.out.println("=================");
            System.out.println("Finish programm.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод main.
     * @param args - параметр.
     */
    public static void main(String[] args) {
        String root = "C:\\projects\\akulikov\\chapter_007\\src\\main\\java\\ru\\job4j\\multithreading\\monitore\\searchtxt\\dir0";
        String text = "PurposeOfSearch!";
        List<String> exts = new ArrayList<>();
        exts.add(".txt");
        ParallerSearch ps = new ParallerSearch(root, text, exts);
        ps.start();
    }
}
