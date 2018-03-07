package ru.job4j.sql.tracker;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** Class tracker.
 * @author Arseniy Kulkiov
 * @since 05.06.2017
 * @version 1
 */
public class Tracker {

    /**
     * Class field.
     */
    public TrackerDataBase tdb = new TrackerDataBase();

    /**
     * position - номер позиции добавляемой заявки в списке заявок.
     */
    private int position = 1;

    /**
     * Метод добавления заявки.
     * @return - возвращение.
     * @param item - заявка.
     */
    public Item add(Item item) {
        boolean result = false;
        try {
            PreparedStatement ps = tdb.getConnection().prepareStatement(queryToStr("addQ"));
            int id = Integer.parseInt(item.getId());
//            System.out.println(id);
            ps.setInt(1, id);
            ps.setString(2, item.getName());
            ps.setString(3, item.getDesc());
            ps.execute();
            ps.close();
            tdb.getConnection().commit();
            this.addComment(item);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Add comment method.
     * @param item - item.
     * @throws SQLException - exception.
     */
    private void addComment(Item item) throws SQLException {
        if (!(item.getComments() == null)) {
            for (int i = 0; i < item.getComments().length; i++) {
                PreparedStatement psComment = tdb.getConnection().prepareStatement(queryToStr("addCommentQ"));
                psComment.setInt(1, this.position++);
                psComment.setString(2, item.getComments()[i]);
                psComment.setInt(3, Integer.parseInt(item.getId()));
                psComment.execute();
                tdb.getConnection().commit();
                psComment.close();
            }
        }
    }

    /**
     * query to String method.
     * @param key - query key.
     * @return - return statement.
     */
    private String queryToStr(String key) {
        return tdb.getProp().getProperty(key);

    }

    /**
     * listFill method.
     * @param rs - ResultSet.
     * @param list - list.
     * @return - return statement.
     * @throws SQLException - exception.
     */
    private List<Item> listFill(ResultSet rs, List<Item> list) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("Name");
            String description = rs.getString("Description");
            Item item = new Item(name, description, Integer.toString(id));
            list.add(item);
        }
        return list;
    }

    /**
     * Метод редактирования заявки.
     * @param item - заявка.
     * @return - возвращение.
     */
    public boolean update(Item item) {
        boolean result = false;
        int id = Integer.parseInt(item.getId());
        try {
            PreparedStatement ps = tdb.getConnection().prepareStatement(queryToStr("updateItemQ"));
            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.setInt(3, id);
            ps.execute();
            tdb.getConnection().commit();
            ps = tdb.getConnection().prepareStatement(queryToStr("clearCommentsQ"));
            ps.setInt(1, id);
            ps.execute();
            tdb.getConnection().commit();
            this.addComment(item);
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод удаления заявки.
     * @param item - заявка.
     * @return - возвращение.

     */
    public boolean delete(Item item) {
        boolean result = false;
        int id = Integer.parseInt(item.getId());
        try {
            PreparedStatement ps = tdb.getConnection().prepareStatement(queryToStr("deleteItemQ"));
            ps.setInt(1, id);
            ps.execute();
            ps = tdb.getConnection().prepareStatement(queryToStr("deleteCommentsQ"));
            ps.setInt(1, id);
            ps.execute();
            tdb.getConnection().commit();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод получения списка всех заявок.
     * @return - возвращение.
     */
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try {
            ResultSet rs = this.tdb.getStatement().executeQuery(queryToStr("allItemsSelect"));
            result = this.listFill(rs, result);
            for (Item item : result) {
                item = this.commentAddToItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Comment add to Item method.
     * @param item - item.
     * @return - return statement.
     * @throws SQLException - exception.
     */
    private Item commentAddToItem(Item item) throws SQLException {
        int id = Integer.parseInt(item.getId());
        PreparedStatement ps = tdb.getConnection().prepareStatement(queryToStr("commentsSpecItemId"));
        ps.setInt(1, id);
        ResultSet commentsSet = ps.executeQuery();
        List<String> commentsList = new ArrayList<>();
        while (commentsSet.next()) {
            commentsList.add(commentsSet.getString("Description"));
        }
        String[] comments = commentsList.toArray(new String[commentsList.size()]);
        item.setComments(comments);
        return item;
    }

    /**
     * Метод получения списка заявок по имени.
     * @return - возвращение.
     * @param key - имя заявки попадающей в получаемый список.
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        try {
            PreparedStatement ps = tdb.getConnection().prepareStatement(queryToStr("allItemsSpecName"));
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            result = this.listFill(rs, result);
            for (Item item : result) {
                item = this.commentAddToItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Метод получения заявки по id.
     * @return - возвращение.
     * @param id - id(идентификатор) заявки.
     */
    public Item findById(String id) {
        Item result = null;
        try {
            PreparedStatement ps = tdb.getConnection().prepareStatement(queryToStr("allItemsSpecId"));
            ps.setInt(1, Integer.parseInt(id));
            String query = String.format("SELECT * FROM ITEMS WHERE id=(%s)", id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idVal = rs.getInt("id");
                String name = rs.getString("Name");
                String description = rs.getString("Description");
                Item item = new Item(name, description, Integer.toString(idVal));
                result = this.commentAddToItem(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}