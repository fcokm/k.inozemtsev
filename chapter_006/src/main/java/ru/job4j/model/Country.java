package ru.job4j.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Data
public class Country {

    @NonNull private String name;
    private List<String> cityList = new ArrayList<>();

    public Country(String name, String city) {
        this.name = name;
        cityList.add(city);
    }

    public Country addCity(String city) {
        this.cityList.add(city);
        return this;
    }
}
