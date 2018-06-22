package ru.job4j.search;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Human implements Comparable<Human>{
    private String name;
    private int age;

    public Human() {
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public int compareTo(Human human){
        if (this.getAge() > human.getAge())
            return 1;
        else if (this.getAge() > human.getAge())
            return -1;
        else
            return 0;
     }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        TreeSet<Human> people = new TreeSet<Human>(Arrays.asList(new Human("Bob",23),
                new Human("Mike",18)));
     for (Human human : people) {
         System.out.println(human);
     }


    }
}
