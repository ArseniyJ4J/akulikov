package ru.job4j.profession;
/** Class Profession.
 * @author Arseniy Kulkiov
 * @since 05.06.2017
 * @version 1
 */
public class Profession {
    /**
     * Объявление полей.
     * @param diplomNumber - номер диплома.
     */
    private int diplomNumber;
    /**
     * @param expirience - опыт (в годах).
     */
    private int expirience;
    /**
     * @param specialization - специализация.
     */
    private String specialization;
    /**
     * @param name - имя.
     */
    private String name;
    /**
     * Метод геттер.
     * @return - возврат значения.
     */
    public int getDiplomNumber() {
        return this.diplomNumber;
    }
    /**
     * Метод геттер.
     * @return - возврат значения.
     */
    public int getExpirience() {
        return this.expirience;
    }
    /**
     * Метод геттер.
     * @return - возврат значения.
     */
    public String getSpecialization() {
        return this.specialization;
    }
    /**
     * Метод геттер.
     * @return - возврат значения.
     */
    public String getName() {
        return this.name;
    }

}
