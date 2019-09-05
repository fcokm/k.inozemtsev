package ru.job4j.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
public class Colour {
    private int id;
    private String name;
    private Set<Car> carSet = new HashSet();
}
