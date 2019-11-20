package ru.job4j.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.User;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;
import ru.job4j.service.CarService;

import javax.servlet.ServletContext;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Controller
public class AutoController {

    @Autowired
    public CarService carService;


    @Autowired
    private ServletContext context;

    private Map<String, Function<String, List<Car>>> getCarsMapWithFilter() {
        Map<String, Function<String, List<Car>>> carsMap = new HashMap<>();
        carsMap.put("mark", getListCarsByMark());
        carsMap.put("all", getListAllCars());
        carsMap.put("photo", getListCarsNotPhoto());
        carsMap.put("last", getListCarByLastDay());
        return carsMap;
    }

    @Bean
    public User getUser() {
        User user = new User();
        user.setId(1);
        return user;
    }

    private Function<String, List<Car>> getListCarsNotPhoto() {
        return s -> carService.findCarsByWithPhoto();
    }

    private Function<String, List<Car>> getListAllCars() {
        return s -> carService.allCars();
    }

    public Function<String, List<Car>> getListCarsByMark() {
        return s -> carService.findCarByMark(s);
    }

    private Function<String, List<Car>> getListCarByLastDay() {
        return s -> carService.getListCarByLastDay();
    }

    @GetMapping("main")
    public String getAll() {
        return "main";
    }

    @GetMapping("add")
    public String getAdd() {
        return "add";
    }


    @GetMapping("cars")
    public @ResponseBody
    Map<String, List<Car>> getAllCarsByMark
            (@RequestParam(value = "data", required = false) String data
                    , @RequestParam(value = "mark_name", required = false) String mark) {
        Map<String, List<Car>> map = new HashMap<>();
        List<Car> cars = getCarsMapWithFilter().get(data)
                .apply(mark);
        map.put("not", cars);
        return map;
    }


    @GetMapping("all")
    public @ResponseBody
    Map<String, List<Car>> getAll1() {
        Map<String, List<Car>> map = new HashMap<>();
        List<Car> cars = carService.allCars();
        map.put("not", cars);
        return map;
    }


    @PostMapping(value = "/add", produces = "application/json")
    public Car addCar(@RequestBody Car car) {
        car.setUser(getUser());
        car.setRegistrationtime(new Timestamp(System.currentTimeMillis()));
        return carService.addOrUpdateCar(car);
    }


    @GetMapping("/allmark")
    public @ResponseBody
    List<MarkCar> getAllMark() {
        return carService.getAllMark();
    }


    @GetMapping("/part")
    public @ResponseBody
    DataClass getAllCarsPart() {
        return new DataClass();
    }

    @GetMapping("model")
    public @ResponseBody
    List<CarModel> getModelByMark
            (@RequestParam("mark") String mark) {
        return carService.findByCarMarkByMark(mark);
    }


    @Data
    @NoArgsConstructor
    private class DataClass {
        private List<Year> year = new ArrayList(carService.getAllYears());
        private List<EngineVolum> engineVolum = new ArrayList(carService.getAllEngineVolum());
        private List<EngineType> engineType = new ArrayList(carService.getAllTypeEngine());
        private List<Transmission> gearbox = new ArrayList(carService.getAllTransmission());
        private List<MarkCar> mark = new ArrayList(carService.getAllMark());
        private List<CarBody> body = new ArrayList(carService.getAllCarBody());
        private List<CarCategory> category = new ArrayList(carService.getAllCarCategory());
        private List<Colour> colour = new ArrayList(carService.getAllColours());

    }
}