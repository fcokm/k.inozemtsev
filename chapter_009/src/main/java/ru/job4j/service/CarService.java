package ru.job4j.service;


import ru.job4j.model.User;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;

import java.util.List;

public interface CarService {


    List<Car> allCars() ;

    List<MarkCar> getAllMark();

    List<EngineType> getAllTypeEngine();

    List<EngineVolum> getAllEngineVolum() ;

    List<Transmission> getAllTransmission();

    List<CarBody> getAllCarBody();

    List<Year> getAllYears();

    List<CarCategory> getAllCarCategory();

    List<Colour> getAllColours();

    Car addOrUpdateCar(final Car car);

    List<CarModel> findByMark(final String mark);

    List<Car> findCar();

    List<Car> getListCarByLastDay();


    List<Car> findCarByMark(final String mark) ;

    User getValidUser(final String login, final String password);
}
