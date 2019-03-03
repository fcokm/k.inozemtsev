package ru.job4j.reflect;

import org.reflections.Reflections;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {





    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections("java.util");
      //  Set<Class<? extends AbstractCollection>> subTypes = reflections.getSubTypesOf(AbstractCollection.class);
        Set<Class<? extends List>> classes = reflections.getSubTypesOf(java.util.List.class);
        for (Class<? extends List> aClass : classes) {
            System.out.println(aClass.getName());
            if(aClass == ArrayList.class) {
                List list = aClass.newInstance();
                list.add("test");
                System.out.println(list.getClass().getName() + ": " + list.size());
            }
        }

    }
}
