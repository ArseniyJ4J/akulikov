package ru.job4j.shapes;
/** Class Класс фигуры треугольника.
 * @author Arseniy Kulkiov
 * @since 27.06.2017
 * @version 1
 */
public class Triangle implements Shape {
    /**
     * Метод рисующий треугольник.
     * @return - возврат значения.
     */
    public String pic() {
        StringBuilder triang = new StringBuilder();
        triang.append(new String("  *"));
        triang.append(System.getProperty("line.separator"));
        triang.append(new String(" ***"));
        triang.append(System.getProperty("line.separator"));
        triang.append(new String("*****"));
        triang.append(System.getProperty("line.separator"));
        return triang.toString();
    }
}
