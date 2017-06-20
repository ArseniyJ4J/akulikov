package ru.job4j.tracker;

/** Class Класс StartUI.
 * @author Arseniy Kulkiov
 * @since 20.06.2017
 * @version 1
 */

public class StartUi {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";

    public void init() {

        boolean menu = true;
        Tracker tracker = new Tracker();

        while (menu) {
            System.out.println ("0. Add new Item");
            System.out.println ("1. Show all items");
            System.out.println ("2. Edit item");
            System.out.println ("3. Delete item");
            System.out.println ("4. Find item by Id");
            System.out.println ("5. Find items by name");
            System.out.println ("6. Exit program");
            ConsoleInput consInput = new ConsoleInput();
            String menuOption = consInput.ask("Select: ");

            if (ADD.equals(menuOption)) {
                String name = consInput.ask("Enter the name of new Item: ");
                String desc = consInput.ask("Enter the description of new Item: ");
                tracker.add(new Item(name, desc));
                System.out.println("Successfully added.");

            } else if (SHOW.equals(menuOption)){
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
                String id = consInput.ask("Enter the id of item: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    String name = consInput.ask("Enter the new name of edited item: ");
                    item.setName(name);
                    String desc = consInput.ask("Enter the description of edited item: ");
                    item.setDesc(desc);
                } else {
                    System.out.println("Unknown Item's Id! Please, enter correct Id.");
                }


            } else if (DELETE.equals(menuOption)) {
                String id = consInput.ask("Enter the id of item: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    tracker.delete(item);
                    System.out.println("Item successfully deleted.");
                } else {
                    System.out.println("Unknown Item's Id! Please, enter correct Id.");
                }

            } else if (FINDID.equals(menuOption)) {
                String id = consInput.ask("Enter the id of item: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.printf("For this Id: %3$s %nName: %1$s; Description: %2$s;%n", item.getName(), item.getDesc(), item.getId());
                } else {
                    System.out.println("Unknown Item's Id! Please, enter correct Id.");
                }

            } else if (FINDNAME.equals(menuOption)) {
                String name = consInput.ask("Enter the name of item: ");
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

    public static void main(String[] args) {
        new StartUi().init();

    }
}
