package ru.job4j.profession;
/** Class Engineer.
 * @author Arseniy Kulkiov
 * @since 05.06.2017
 * @version 1
 */
public class Engineer extends Profession {
    /**
     * Метод начала проекта.
     */
    public void startProject() {
    }
    /**
     * Метод расчёта конструктивного элемента.
     * @param beam - параметр конструктивного элемента.
     * @return - возврат значения.
     */
    public int structuralCulculation(int beam) {
        return beam;
    }
    /**
     * Метод проведения архитектурного надзора за проектом.
     */
    public void architecturalSupervision() {
    }
    /**
     * Метод проведения инженерной оптимизации проекта.
     * @return - возврат значения.
     */
    public String engineerOptimization() {
        return null;
    }
}
