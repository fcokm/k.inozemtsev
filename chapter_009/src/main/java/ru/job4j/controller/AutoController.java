package ru.job4j.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Role;
import ru.job4j.model.User;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;
import ru.job4j.repository.RoleRepository;
import ru.job4j.repository.UserRepository;
import ru.job4j.service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
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
    public UserRepository userRepository;

    @Autowired
    public RoleRepository roleRepository;

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

    @Bean
    public Role  userRole() {
        Role role = new Role();
        role.setId(2);
        return role;
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
    public String main() {
        return "main";
    }

    @GetMapping("registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("registration")
    public String addUser(User user, ModelMap model) {
      User searchUser = userRepository.findByLogin(user.getLogin());
        if(searchUser != null) {
            model.addAttribute("message", "User exists");
            return "registration";
        }
             user.setRole(userRole());
             user.setActive(true);
             userRepository.save(user);
        return "redirect:login";
    }


    @GetMapping("logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }


    @GetMapping("add")
    public String add() {
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
    Map<String, List<Car>> allCar() {
        Map<String, List<Car>> map = new HashMap<>();
        List<Car> cars = carService.allCars();
        map.put("not", cars);
        return map;
    }


    @PostMapping(value = "/add", produces = "application/json")
    public Car addCar(@RequestBody Car car, Principal principal) {
        User user =  userRepository.findByLogin(principal.getName());
        car.setUser(user);
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