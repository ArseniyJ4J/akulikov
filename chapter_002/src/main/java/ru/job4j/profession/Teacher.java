package ru.job4j.profession;

/** Class Teacher.
 * @author Arseniy Kulkiov
 * @since 05.06.2017
 * @version 1
 */
public class Teacher extends Profession {
    /**
     * Объявление поля academicDegree  - учёная степень.
     * @param academicDegree - учёная степень.
     */
    String academicDegree;
    /**
     * Метод начала занятия.
     */
    public void startLession(){
    }
    /**
     * Метод окончания занятия.
     */
    public void finishLesson(){
    }
    /**
     * Метод проверки задания.
     * @param task - объект типа Assignment (задание).
     * @return - возврат значения.
     */
    public String verifyTask (Task task) {
        return null;
    }
    /**
     * Метод оценки выполнения задания на два балла.
     * @param task - объект типа Assignment (задание).
     * @return - возврат значения.
     */
    public String rateTwoPoint (Task task) {
        return "two ball";
    }
    /**
     * Метод проверки задания.
     * @param task - объект типа Assignment (задание).
     * @return - возврат значения.
     */
    public void exzamine (Task task) {
    }

}