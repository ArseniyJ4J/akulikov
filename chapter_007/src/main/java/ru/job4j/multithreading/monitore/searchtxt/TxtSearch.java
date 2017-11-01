package ru.job4j.multithreading.monitore.searchtxt;

import java.io.*;
import java.util.List;

/**
 * TxtSearch Class.
 * @author Arseniy Kulikov.
 * @since 01.11.2017.
 * @version 1.
 */
public class TxtSearch implements Runnable {

    /**
     * Поле класса.
     */
    private int count = 0;

    /**
     * Поле класса.
     */
    private BlockingQueue<String> filepaths;

    /**
     * Поле класса.
     */
    private List<String> result;

    /**
     * Поле класса.
     */
    private String text;

    /**
     * Конструктор.
     * @param result - контейнер для реузльтатов.
     * @param filePaths - контейнер для файлов.
     * @param text - текст для поиска.
     */
    public TxtSearch(List<String> result, BlockingQueue<String> filePaths, String text) {
        this.result = result;
        this.filepaths = filePaths;
        this.text = text;
    }

    /**
     * Метод поиска текста в файле.
     * @param path - путь к файлу.
     */
    public void searching(String path) {
        try {
            FileInputStream fstream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                if (strLine.contains(this.text)) {
                    result.add(path);
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (filepaths.getWillBeNew() || filepaths.size() != 0) {
                String path = filepaths.take();
                this.searching(path);
            }
            System.out.printf("В %s файлах найден указанный текст.%n", this.count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
