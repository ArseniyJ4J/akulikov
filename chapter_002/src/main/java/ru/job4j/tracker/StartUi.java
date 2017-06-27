package ru.job4j.tracker;

/** Class Класс StartUI.
 * @author Arseniy Kulkiov
 * @since 20.06.2017
 * @version 1
 */

public class StartUi {
    /**
     * ADD - добавление заявки.
     */
    private static final String ADD = "0";
    /**
     * SHOW - показать все заявки.
     */
    private static final String SHOW = "1";
    /**
     * EDIT - отредактировать заявку.
     */
    private static final String EDIT = "2";
    /**
     * DELETE - удалить заявку.
     */
    private static final String DELETE = "3";
    /**
     * FINDID - найти заявку по идентификационному номеру.
     */
    private static final String FINDID = "4";
    /**
     * FINDNAME - найти заявку по имени.
     */
    private static final String FINDNAME = "5";
    /**
     * EXIT - выход из программы.
     */
    private static final String EXIT = "6";
    /**
     * EXIT - выход из программы.
     */
    private Input input;

    public Tracker tracker;

    public StartUi(Input input, Tracker tracker) {
        this.tracker = tracker;
        this.input = input;
    }


    public StartUi(Input input) {
        this.input = input;
    }

    public StartUi(){
    }
    /**
     * Метод инициализатор метода main.
     */
    public void init() {

        boolean menu = true;

        while (menu) {
            System.out.println("0. Add new Item");
            System.out.println("1. Show all items");
            System.out.println("2. Edit item");
            System.out.println("3. Delete item");
            System.out.println("4. Find item by Id");
            System.out.println("5. Find items by name");
            System.out.println("6. Exit program");
            String menuOption = input.ask("Select: ");

            if (ADD.equals(menuOption)) {
                String name = input.ask("Enter the name of new Item: ");
                String desc = input.ask("Enter the description of new Item: ");
                tracker.add(new Item(name, desc));
                System.out.println("Successfully added.");

            } else if (SHOW.equals(menuOption)) {
                Item[] items = tracker.findAll();
                if (items.length == 0) {
                    System.out.println("The Tracker is empty.");
                } else {
                    for (Item item : items) {
                        System.out.printf("Name: %s; Description: %s; Id: %s.%n", item.getName(), item.getDesc(), item.getId());
                        //System.out.println("Name: " + item.getName() + "; Description: " + item.getDesc() + "; Id: " + item.getId() + ".");
                    }
                }

            } else if (EDIT.equals(menuOption)) {
                String id = input.ask("Enter the id of item: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    String name = input.ask("Enter the new name of edited item: ");
                    item.setName(name);
                    String desc = input.ask("Enter the description of edited item: ");
                    item.setDesc(desc);
                } else {
                    System.out.println("Unknown Item's Id! Please, enter correct Id.");
                }


            } else if (DELETE.equals(menuOption)) {
                String id = input.ask("Enter the id of item: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    tracker.delete(item);
                    System.out.println("Item successfully deleted.");
                } else {
                    System.out.println("Unknown Item's Id! Please, enter correct Id.");
                }

            } else if (FINDID.equals(menuOption)) {
                String id = input.ask("Enter the id of item: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.printf("For this Id: %3$s %nName: %1$s; Description: %2$s;%n", item.getName(), item.getDesc(), item.getId());
                } else {
                    System.out.println("Unknown Item's Id! Please, enter correct Id.");
                }

            } else if (FINDNAME.equals(menuOption)) {
                String name = input.ask("Enter the name of item: ");
                Item[] items = tracker.findByName(name);
                if (items.length != 0) {
                    System.out.printf("Item(s) by \"%s\" name:%n", name);
                    for (Item item : items) {
                        System.out.printf("Id: %s; Description: %s;%n", item.getId(), item.getDesc());
                    }
                } else {
                    System.out.println("No item(s) with such name.");

                }

            } else if (EXIT.equals(menuOption)) {
                menu = false;
            }
        }
    }
    /**
     * Метод main.
     * @param args - строки из консоли.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUi(input).init();

    }
}
