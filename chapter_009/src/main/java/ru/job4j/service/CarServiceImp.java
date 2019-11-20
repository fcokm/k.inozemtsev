package ru.job4j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.model.User;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Status;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;
import ru.job4j.repository.*;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarServiceImp implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    public MarkCarRepository markCarRepository;

    @Autowired
    public CarBodyRepository carBodyRepository;

    @Autowired
    public CarCategoryRepository carCategoryRepository;

    @Autowired
    public EngineTypeRepository engineTypeRepository;

    @Autowired
    public TransmissionRepository transmissionRepository;

    @Autowired
    public EngineVolumRepository engineVolumRepository;

    @Autowired
    public CarModelRepository carModelRepository;

    @Autowired
    public ColourRepository colourRepository;

    @Autowired
    public YearRepository yearRepository;


   @Override
    @Transactional
    public List<Car> allCars() {
       List<Car> list = new ArrayList<>();
        carRepository.findAll().forEach(list::add);
        return list;
    }

   @Override
    @Transactional
    public List<MarkCar> getAllMark() {
       List<MarkCar> list = new ArrayList<>();
       markCarRepository.findAll().forEach(list::add);
        return list;
    }

   @Override
    @Transactional
    public List<EngineType> getAllTypeEngine() {
       List<EngineType> list = new ArrayList<>();
       engineTypeRepository.findAll().forEach(list::add);
       return list;
    }

   @Override
    @Transactional
    public List<EngineVolum> getAllEngineVolum() {
       List<EngineVolum> list = new ArrayList<>();
       engineVolumRepository.findAll().forEach(list::add);
       return list;
    }

   @Override
    @Transactional
    public List<Transmission> getAllTransmission() {
       List<Transmission> list = new ArrayList<>();
       transmissionRepository.findAll().forEach(list::add);
       return list;
    }

   @Override
    @Transactional
    public List<CarBody> getAllCarBody() {
       List<CarBody> list = new ArrayList<>();
       carBodyRepository.findAll().forEach(list::add);
       return list;
    }

   @Override
    @Transactional
    public List<Year> getAllYears() {
       List<Year> list = new ArrayList<>();
       yearRepository.findAll().forEach(list::add);
       return list;
    }

   @Override
    @Transactional
    public List<CarCategory> getAllCarCategory() {
       List<CarCategory> list = new ArrayList<>();
       carCategoryRepository.findAll().forEach(list::add);
       return list;
    }

   @Override
    @Transactional
    public List<Colour> getAllColours() {
       List<Colour> list = new ArrayList<>();
       colourRepository.findAll().forEach(list::add);
       return list;
    }

   @Override
    @Transactional
    public Car addOrUpdateCar(Car car) {
       car.setStatus(Status.ISFORSALE);
       return carRepository.save(car);
    }

   @Override
    @Transactional
    public List<CarModel> findByCarMarkByMark(String mark) {
       return carModelRepository.findCarModelByMarkCar(mark);
    }

   @Override
    @Transactional
    public List<Car> findCarsByWithPhoto() {
       return carRepository.findCarsByWithPhoto();
    }

   @Override
    @Transactional
    public List<Car> getListCarByLastDay() {
       return carRepository.findCarsByLastDay();
    }

   @Override
    @Transactional
    public List<Car> findCarByMark(String mark) {
       return carRepository.findCarsByMarkCar(mark);
    }

   @Override
    @Transactional
    public User getValidUser(String login, String password) {
       return null;
    }
}
