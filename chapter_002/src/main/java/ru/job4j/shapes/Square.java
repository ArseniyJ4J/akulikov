package ru.job4j.shapes;
/** Class Класс фигуры квадрата.
 * @author Arseniy Kulkiov
 * @since 27.06.2017
 * @version 1
 */
public class Square implements Shape {
    /**
     * Метод рисующий пустотелый кавдрат.
     * @return - возврат значения.
     */
    public String pic() {
        StringBuilder square = new StringBuilder();
        square.append(new String(" ****"));
        square.append(System.getProperty("line.separator"));
        square.append(new String(" *  *"));
        square.append(System.getProperty("line.separator"));
        square.append(new String(" *  *"));
        square.append(System.getProperty("line.separator"));
        square.append(new String(" ****"));
        square.append(System.getProperty("line.separator"));
        return square.toString();
    }
}
