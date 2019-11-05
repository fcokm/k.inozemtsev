package ru.job4j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.dao.CarDAO;
import ru.job4j.model.User;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;
import java.util.List;


@Service
public class CarServiceImp implements CarService {
    
   @Autowired
   private CarDAO carDAO;

   @Override
    @Transactional
    public List<Car> allCars() {
        return carDAO.allCars();
    }

   @Override
    @Transactional
    public List<MarkCar> getAllMark() {
        return carDAO.getAllMark();
    }

   @Override
    @Transactional
    public List<EngineType> getAllTypeEngine() {
        return carDAO.getAllTypeEngine();
    }

   @Override
    @Transactional
    public List<EngineVolum> getAllEngineVolum() {
        return carDAO.getAllEngineVolum();
    }

   @Override
    @Transactional
    public List<Transmission> getAllTransmission() {
        return carDAO.getAllTransmission();
    }

   @Override
    @Transactional
    public List<CarBody> getAllCarBody() {
        return carDAO.getAllCarBody();
    }

   @Override
    @Transactional
    public List<Year> getAllYears() {
        return carDAO.getAllYears();
    }

   @Override
    @Transactional
    public List<CarCategory> getAllCarCategory() {
        return carDAO.getAllCarCategory();
    }

   @Override
    @Transactional
    public List<Colour> getAllColours() {
        return carDAO.getAllColours();
    }

   @Override
    @Transactional
    public Car addOrUpdateCar(Car car) {
        return carDAO.addOrUpdateCar(car);
    }

   @Override
    @Transactional
    public List<CarModel> findByMark(String mark) {
        return carDAO.findByMark(mark);
    }

   @Override
    @Transactional
    public List<Car> findCar() {
        return carDAO.findCar();
    }

   @Override
    @Transactional
    public List<Car> getListCarByLastDay() {
        return carDAO.getListCarByLastDay();
    }

   @Override
    @Transactional
    public List<Car> findCarByMark(String mark) {
        return carDAO.findCarByMark(mark);
    }

   @Override
    @Transactional
    public User getValidUser(String login, String password) {
        return carDAO.getValidUser(login,password);
    }
}
