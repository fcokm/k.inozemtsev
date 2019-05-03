package ru.job4j.model;

import java.util.*;

public class Country {
    private String name;
    private List<String> cityList = new ArrayList<>();
    public Country() {
    }

    public Country(String name, String city) {
        this.name = name;
        cityList.add(city);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCityList() {
        return cityList;
    }

    public Country addCity(String city) {
        this.cityList.add(city);
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) &&
                Objects.equals(cityList, country.cityList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, cityList);
    }

    @Override
    public String toString() {
        return String.format(
                "%s,%s"
                , name, cityList);

    }
}
