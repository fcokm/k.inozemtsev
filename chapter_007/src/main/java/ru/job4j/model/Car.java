package ru.job4j.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Car {
    private int id;
    private CarBody carBody;
    private Colour colour;
    private Engine engine;
    private  MarkCar markCar;
    private Transmission transmission;


    @Override
    public String toString() {
        return String.format("%d %s  %s  %s %s %s",
                id
                , colour.getName()
                , markCar.getName()
                , carBody.getBody()
                , engine.getName()
                , transmission.getType());
    }
}
