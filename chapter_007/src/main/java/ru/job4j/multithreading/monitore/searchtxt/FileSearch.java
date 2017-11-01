package ru.job4j.multithreading.monitore.searchtxt;

import java.io.File;
import java.util.List;

/**
 * FileSearch Class.
 * @author Arseniy Kulikov.
 * @since 01.11.2017.
 * @version 1.
 */
public class FileSearch implements Runnable {

    /**
     * Поле класса.
     */
    private String root;

    /**
     * Поле класса.
     */
    private List<String> exts;

    /**
     * Поле класса.
     */
    private BlockingQueue<String> filepaths;

    /**
     * Поле класса.
     */
    private int countDir = 0;

    /**
     * Поле класса.
     */
    private int countFiles = 0;

    /**
     * Поле класса.
     */
    private int countSpecFiles = 0;

    /**
     * Конструктор.
     * @param root - корень поиска.
     * @param exts - список расширений файлов для поиска.
     * @param filepaths - контейнер для файлов.
     */
    public FileSearch(String root, List<String> exts, BlockingQueue<String> filepaths) {
        this.exts = exts;
        this.root = root;
        this.filepaths = filepaths;
    }

    /**
     * Метод обхода файловой системы внутрь от корня.
     * @param path - путь корневого файла.
     * @throws InterruptedException - исключение.
     */
    private void moveInside(String path) throws InterruptedException {
        File root = new File(path);
        File[] list = root.listFiles();
        for (File file : list) {
            if (file.isDirectory()) {
                this.moveInside(file.getPath());
                countDir++;
            } else {
                countFiles++;
                for (String value : this.exts) {
                    if (file.getName().contains(value)) {
                        filepaths.put(file.getPath());
                        countSpecFiles++;
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            this.moveInside(root);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        filepaths.setWillBeNew(false);
        System.out.printf("Всего файлов: %s%nИз них каталогов: %s%nПрочих файлов %s%nВ прочих файлах найдено %s файлов нужного расширения.%n", countDir + countFiles, countDir, countFiles, countSpecFiles);
    }
}
