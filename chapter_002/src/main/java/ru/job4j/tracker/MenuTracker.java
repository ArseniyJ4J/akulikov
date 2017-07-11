package ru.job4j.tracker;

/** Class Класс MenuTracker.
 * @author Arseniy Kulkiov
 * @since 03.07.2017
 * @version 1
 */

public class MenuTracker {
    /**
     * input - ввод.
     */
    private Input input;
    /**
     * tracker - трекер.
     */
    private Tracker tracker;
    /**
     * actions - массив действий меню.
     */
    private UserAction[] actions = new UserAction[7];
    /**
     * Конструктор.
     * @param input - ввод.
     * @param tracker - трекер.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод заполнения массива действий соответствующими методами.
     */
    public void fillAction() {
        this.actions[0] = new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = this.new EditItem();
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new FindById();
        this.actions[5] = this.new FindByName();
        this.actions[6] = this.new Exit();
    }
    /**
     * Метод геттер поля actions.
     * @return - возврат actions.
     */
    public UserAction[] getActions() {
        return this.actions;
    }
    /**
     * Метод ввода выбора "ключа" пункта меню.
     * @param key - "ключ"/номер пункта меню.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    /**
     * Метод выполняющий вывод меню на консоль.
     */
    public void show() {
        for (UserAction action : this.actions) {
            System.out.println(action.info());
        }
    }
    /**
     * внутренний внешний нестатический класс добавления заявки.
     */
    class AddItem implements UserAction {
        /**
         * Метод возврата значения ключа.
         * @return - возврат.
         */
        public int key() {
            return 0;
        }
        /**
         * Метод выполнения добавления заявки.
         * @param input - ввод.
         * @param tracker - трекер.
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Please, enter the name of new Item: ");
            String desc = input.ask("Please enter the description of new Item: ");
            tracker.add(new Item(name, desc));
            System.out.println("Successfully added.");
        }
        /**
         * Метод возвращающий строку для отображения в меню.
         * @return - возврат.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }
    /**
     * Внутренний статический класс отображения всех заявок.
     */
    private static class ShowItems implements UserAction {
        /**
         * Метод возврата значения ключа.
         * @return - возврат.
         */
        public int key() {
            return 1;
        }
        /**
         * Метод выполнения отображения всех заявок.
         * @param input - ввод.
         * @param tracker - трекер.
         */
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            if (items.length == 0) {
                System.out.println("The Tracker is empty.");
            } else {
                for (Item item : items) {
                    System.out.printf("Name: %s; Description: %s; Id: %s.%n", item.getName(), item.getDesc(), item.getId());
                    //System.out.println("Name: " + item.getName() + "; Description: " + item.getDesc() + "; Id: " + item.getId() + ".");
                }
            }
        }
        /**
         * Метод возвращающий строку для отображения в меню.
         * @return - возврат.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }
    /**
     * Внутренний нестатический класс редактирования заявки.
     */
    private class EditItem implements UserAction {
        /**
         * Метод возврата значения ключа.
         * @return - возврат.
         */
        public int key() {
            return 2;
        }
        /**
         * Метод выполнения отображения всех заявок.
         * @param input - ввод.
         * @param tracker - трекер.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the id of edited item: ");
            Item item = tracker.findById(id);
            if (item != null) {
                String name = input.ask("Enter the new name of edited item: ");
                item.setName(name);
                String desc = input.ask("Enter the description of edited item: ");
                item.setDesc(desc);
                System.out.println("Successfully edited.");
            } else {
                System.out.println("Unknown Item's Id! Please, enter correct Id.");
            }
        }
        /**
         * Метод возвращающий строку для отображения в меню.
         * @return - возврат.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item.");
        }
    }
    /**
     * Внутренний нестатический класс удаления заявки.
     */
    private class DeleteItem implements UserAction {
        /**
         * Метод возврата значения ключа.
         * @return - возврат.
         */
        public int key() {
            return 3;
        }
        /**
         * Метод выполнения удаления заявки.
         * @param input - ввод.
         * @param tracker - трекер.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the id of deleted item: ");
            Item item = tracker.findById(id);
            if (item != null) {
                tracker.delete(item);
                System.out.println("Item successfully deleted.");
            } else {
                System.out.println("Unknown Item's Id! Please, enter correct Id.");
            }
        }
        /**
         * Метод возвращающий строку для отображения в меню.
         * @return - возврат.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }
    /**
     * Внутренний нестатический класс поиска заявки по Id.
     */
    private class FindById implements UserAction {
        /**
         * Метод возврата значения ключа.
         * @return - возврат.
         */
        public int key() {
            return 4;
        }
        /**
         * Метод выполнения поиска заявки по Id.
         * @param input - ввод.
         * @param tracker - трекер.
         */
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the id of item: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.printf("For this Id: %3$s %nName: %1$s; Description: %2$s;%n", item.getName(), item.getDesc(), item.getId());
            } else {
                System.out.println("Unknown Item's Id! Please, enter correct Id.");
            }
        }
        /**
         * Метод возвращающий строку для отображения в меню.
         * @return - возврат.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by Id.");
        }
    }
    /**
     * Внутренний нестатический класс поиска заявки по имени.
     */
    private class FindByName implements UserAction {
        /**
         * Метод возврата значения ключа.
         * @return - возврат.
         */
        public int key() {
            return 5;
        }
        /**
         * Метод выполнения поиска заявки(-ок) по имени.
         * @param input - ввод.
         * @param tracker - трекер.
         */
        public void execute(Input input, Tracker tracker) {
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
        }
        /**
         * Метод возвращающий строку для отображения в меню.
         * @return - возврат.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Find item(s) by name.");
        }
    }
    /**
     * Внутренний нестатический класс выхода из программы.
     */
    private class Exit implements UserAction {
        /**
         * Метод возврата значения ключа.
         * @return - возврат.
         */
        public int key() {
            return 6;
        }
        /**
         * Метод ничего не выполняющий. Просто реалзиация интерфейса.
         * @param input - ввод.
         * @param tracker - трекер.
         */
        public void execute(Input input, Tracker tracker) {

        }
        /**
         * Метод возвращающий строку для отображения в меню.
         * @return - возврат.
         */
        public String info() {
            return String.format("%s. %s", this.key(), "Exit.");
        }
    }
}
