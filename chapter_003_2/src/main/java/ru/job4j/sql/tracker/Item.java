package ru.job4j.sql.tracker;

import java.util.Arrays;

/** Class Класс заявки.
 * @author Arseniy Kulkiov
 * @since 07.06.2017
 * @version 1
 */
public class Item {
    @Override
    public String toString() {
        return "Item{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", desc='" + desc + '\''
                + ", created=" + created
                + ", comments=" + Arrays.toString(comments)
                + '}';
    }

    /**
     * id - идентификационный номер.
     */
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        return id != null ? id.equals(item.id) : item.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    /**
     * name - имя заявки.
     */

    private String name;
    /**
     * desc - описания заявки.
     */
    private String desc;
    /**
     * created - дата создания.
     */
    private long created;
    /**
     * comments - комментарии к заявке.
     */
    private String[] comments;
    /**
     * Конструктор.
     * @param name - имя заявки.
     * @param desc - описание заявки.
     */
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    /**
     * Конструктор.
     * @param name - имя заявки.
     * @param desc - описание заявки.
     * @param id - идентификационный номер заявки.
     */
    public Item(String name, String desc, String id) {
        this.name = name;
        this.desc = desc;
        this.id = id;
    }
    /**
     * Метод геттер.
     * @return - возврат значения.
     */
    public String getId() {
        return this.id;
    }
    /**
     * Метод сеттер.
     * @param id - идентификационный номер заявки.
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Метод геттер.
     * @return - возврат значения.
     */
    public String getName() {
        return this.name;
    }
    /**
     * Метод сеттер.
     * @param name - имя заявки.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Метод геттер.
     * @return - возврат значения.
     */
    public String getDesc() {
        return this.desc;
    }
    /**
     * Метод сеттер.
     * @param desc - описание заявки.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    /**
     * Метод геттер.
     * @return - возврат значения.
     */
    public long getCreated() {
        return this.created;
    }
    /**
     * Метод сеттер.
     * @param created - дата создания заявки.
     */
    public void setDesc(long created) {
        this.created = created;
    }
    /**
     * Метод геттер.
     * @return - возврат значения.
     */
    public String[] getComments() {
        return this.comments;
    }
    /**
     * Метод сеттер.
     * @param comments - комментарии к заявкам.
     */
    public void setDesc(String[] comments) {
        this.comments = comments;
    }
}
