package ru.job4j.pseudo;

/**
 * Class Paint базовый класс реализации фигуры.
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Paint {
    /**
     * Получение фигуры.
     */
  private Shape shape;

    /**
     * Конструктор - создание нового объекта
     */
  public Paint() {
  }
    /**
     * Конструктор - создание нового объекта с параметрами
     * @param  shape фигура
     */
  public Paint(Shape shape) {
      this.shape = shape;
  }

    /**
     * Метод печатает псевдокартинку на консоль
     *@param shape строка с запросом для пользователя
     */
	public void draw(Shape shape) {
     System.out.println(shape.draw());
	}

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new Paint().draw(new Triangle());
    }
}
