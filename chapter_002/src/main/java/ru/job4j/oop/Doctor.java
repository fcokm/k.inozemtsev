package ru.job4j.oop;

/**
 *  Class Doctor реализует профессию доктора
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Doctor extends Profession {


   /**
    * Конструктор - создание нового объекта
    */
   public Doctor() {
   }

   /**
    * Конструктор - создание нового объекта с параметрами
    *
    * @param name       - имя
    * @param profession - название профессии
    */
   public Doctor(String name, String profession) {
      super(name, profession);
   }

   /**
    * Метод возвращает строку
    *@param patient пациент
    *@return строка.
    */

   public String treatsPatient(Patient patient) {
      return this.profession + " " + this.name + " " + "лечит"  + " " + patient.getName();
   }

}
