package ru.job4j.pseudo;

/**
 * Class Triangle
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Triangle implements Shape {

    /**
     * Метод возвращает фигуру в виде строки
     * @return  строка
     */
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  +  \n");
        pic.append(" + + \n");
        pic.append("+++++\n");
        return pic.toString();
    }

}
