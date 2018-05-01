package ru.job4j.tracker;

/**
 * Class Item
 *
 * @author Konstantin Inozemcev (9715791@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class Item {
    /**
     * индификатор заявки.
     */
    private String id;
    /**
     * Название заявки.
     */
    private String name;
    /**
     * Описание  заявки.
     */
    private String desc;
    /**
     * Дата создания завки.
     */
    private long creared;
    /**
     * Массив для хранение заявок.
     */
    private String[] comments;

    /**
     * Конструктор - создание нового объекта
     */
    public Item() {
    }

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param name       - имя
     * @param desc - описание заявки
     * @param creared - дата создания заявки.
     */

    public Item(String name, String desc, long creared) {
        this.name = name;
        this.desc = desc;
        this.creared = creared;
    }

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param name       - имя
     * @param desc - описание заявки
     */

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /**
     * Конструктор - создание нового объекта с параметрами
     *
     * @param name       - имя
     * @param desc - описание заявки
     */

    public Item(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    /**
     * Метод получения значения поля id
     * @return id
     */

    public String getId() {
        return id;
    }
    /**
     * Метод присваивает  значения поля name
     * @param id - индефикатор заявки
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Метод получения значения поля name
     * @return name имя
     */
    public String getName() {
        return name;
    }

    /**
     * Метод  присваивает  значения поля name
     * @param name - имя заявки
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Метод получения значения поля desc
     * @return desc описание.
     */

    public String getDesc() {
        return desc;
    }

    /**
     * Метод  присваивания  значения поля desc
     * @param desc - описание заявки
     */

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Метод получения значения поля creared
     * @return creared  описание заявки.
     */
      public long getCreared() {
        return creared;
    }

    /**
     * Метод  присваивания  значения поля creared
     * @param creared - дата создания.
     */
    public void setCreared(long creared) {
        this.creared = creared;
    }

    /**
     * Метод получения значения поля массива comments
     * @return comments  массив строк.
     */

    public String[] getComments() {
        return comments;
    }

    /**
     * Переопределение метода toString()
     * @return строка.
     */

    @Override
    public String toString() {
        return "Item["
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", desc='" + desc + '\''
                + ", creared=" + creared
                + ']';
    }
}
