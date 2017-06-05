package ru.job4j.profession;
/** Class Engineer.
 * @author Arseniy Kulkiov
 * @since 05.06.2017
 * @version 1
 */
public class Engineer extends Profession {
    /**
     * Объявление поля project  - завершенные проекты.
     * @param projects - завершенные проекты.
     */
    String projects;
    /**
     * Метод начала проекта.
     * @param project - объект типа project (проект).
     */
    public void startProject (Project project){
    }
    /**
     * Метод расчёта конструктивного элемента.
     * @param beam - параметр конструктивного элемента.
     * @return - возврат значения.
     */
    public int structuralCulculation (int beam) {
        return beam;
    }
    /**
     * Метод проведения архитектурного надзора за проектом.
     * @param project - объект типа project (проект).
     * @return - возврат значения.
     */
    public void architecturalSupervision (Project project) {
    }
    /**
     * Метод проведения инженерной оптимизации проекта.
     * @param project - объект типа project (проект).
     * @return - возврат значения.
     */
    public Project engineerOptimization (Project project) {
        return project;
    }
}
