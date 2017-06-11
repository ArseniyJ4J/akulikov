package ru.job4j.tracker;
/** Class Класс заявки.
 * @author Arseniy Kulkiov
 * @since 07.06.2017
 * @version 1
 */
public class Item {

    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item(String name, String desc, String id) {
        this.name = name;
        this.desc = desc;
        this.id = id;

    }

    public String getId(){
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc(){
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreated(){
        return this.created;
    }

    public void setDesc(long created) {
        this.created = created;
    }

    public String[] getComments(){
        return this.comments;
    }

    public void setDesc(String[] comments) {
        this.comments = comments;
    }
}
