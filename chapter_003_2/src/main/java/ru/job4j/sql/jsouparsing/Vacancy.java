package ru.job4j.sql.jsouparsing;

import java.sql.Timestamp;
import java.util.Objects;

/** Class Vacancy.
 * @author Arseniy Kulkiov
 * @since 16.03.2017
 * @version 1
 */
public class Vacancy {
    /**
     * Class field.
     */
    private String title;
    /**
     * Class field.
     */
    private String author;
    /**
     * Class field.
     */
    private String description;
    /**
     * Class field.
     */
    private Timestamp dateCreation;
    /**
     * Class field.
     */
    private Timestamp dateUpdate;
    /**
     * Getter.
     * @return - retern statement.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Setter.
     * @param title - parameter.
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Getter.
     * @return - retern statement.
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Setter.
     * @param author - parameter.
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * Getter.
     * @return - retern statement.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Setter.
     * @param description - parameter.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Getter.
     * @return - retern statement.
     */
    public Timestamp getDateCreation() {
        return dateCreation;
    }
    /**
     * Setter.
     * @param dateCreation - parameter.
     */
    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }
    /**
     * Getter.
     * @return - retern statement.
     */
    public Timestamp getDateUpdate() {
        return dateUpdate;
    }
    /**
     * Setter.
     * @param dateUpdate - parameter.
     */
    public void setDateUpdate(Timestamp dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    /**
     * Constructor.
     * @param title - parameter.
     * @param author - parameter.
     * @param description - parameter.
     * @param dateCreation - parameter.
     * @param dateUpdate - parameter.
     */
    public Vacancy(String title, String author, String description, Timestamp dateCreation, Timestamp dateUpdate) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.dateCreation = dateCreation;
        this.dateUpdate = dateUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(title, vacancy.title) && Objects.equals(author, vacancy.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return String.format("Title: %s\nAuthor: %s\nDescription: %s\nDateCreation: %s\nDateUpdate: %s", title, author, description, dateCreation, dateUpdate);
    }
}
