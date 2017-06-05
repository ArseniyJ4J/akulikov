package ru.job4j.profession;
/** Class Doctor.
 * @author Arseniy Kulkiov
 * @since 05.06.2017
 * @version 1
 */
public class Doctor extends Profession {
    /**
     * Объявление поля academicDegree  - учёная степень.
     * @param academicDegree - учёная степень.
     */
    String academicDegree;
    /**
     * Метод выписывающий пациента.
     * @param patient - объект типа Patient (пациент).
     */
    public void diacharge(Patient patient){
    }
    /**
     * Метод постановки диагноза.
     * @param patient - объект типа Patient (пациент).
     * @return - возврат значения.
     */
    public Diagnoze diagnozeCase (Patient patient) {
        return null;
    }
    /**
     * Метод выписки рецепта.
     * @param diagnoze - объект типа Diagnoze (диагноз).
     * @return - возврат значения.
     */
    public Order toOrderMedication (Diagnoze diagnoze) {
        return null;
    }
    /**
     * Метод выписки заключения.
     * @param diagnoze - объект типа Diagnoze (диагноз).
     * @return - возврат значения.
     */
    public Medicate medicate (Diagnoze diagnoze) {
        return null;
    }

}
