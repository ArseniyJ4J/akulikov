package ru.job4j.shapes;
/** Class Класс фигуры-картинки.
 * @author Arseniy Kulkiov
 * @since 27.06.2017
 * @version 1
 */
public class Paint {
    /**
     * Метод вызывающий рисование фигуры.
     * @param shape - параметр типа shape.
     */
    public void draw(Shape shape) {
        System.out.print(shape.pic());
    }
}
