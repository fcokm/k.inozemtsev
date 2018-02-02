package ru.job4j.condition;


    /**
     * Class Point описывает точку в системе координат.
     *
     * @author Konstantin Inozemcev (9715791@gmail.com)
     * @version $Id$
     * @since 0.1
     */
    public class Point {

        private int x;

        private int y;

        /**
         * Конструктор создает точку по указынным координатам
         *
         * @param х - координата точки по оси х.
         * @param х - координата точки по оси у.
         */
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
		
        }

        /**
         * Метод возвращает расстояние между двумя точками .
         *
         * @param that точка относительно который рассчитывается расстояние .
         * @result result расстояние между двумя точками.
         */
        public double distanceTo(Point that) {
            Point a = this;
            Point b = that;

            int x1 = a.x;
            int y1 = a.y;
            int x2 = b.x;
            int y2 = b.y;
            double result = Math.sqrt(
                    Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)
            );
            return result;
        }

    }