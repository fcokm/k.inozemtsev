package ru.job4j.servlets;

public class Person {
    String name;
    String surname;
    String gender;
    String desc;

    public Person(String name, String surname, String gender, String desc) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.desc = desc;
    }

    public Person() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return String.format(
                " Name: %s, Surname: %s, Gender: %s, Desc: %s ",
                 name, surname, gender, desc);

    }
}
