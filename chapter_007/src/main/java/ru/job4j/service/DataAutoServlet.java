package ru.job4j.service;

import org.codehaus.jackson.map.ObjectMapper;
import ru.job4j.db.DBStorage;
import ru.job4j.model.car.Car;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class DataAutoServlet extends HttpServlet {
    private final DBStorage storage = DBStorage.getInstance();
    private final Map<String, List<Car>> map = new ConcurrentHashMap<>();
    private final Map<String, Function<String, List<Car>>> mp = new HashMap<>();

    @Override
    public void init() {
        mp.put("all", getListAllCars());
        mp.put("mark", getListCarsByMark());
        mp.put("photo", getListCarsNotPhoto());
        mp.put("last", getListCarByLastDay());
    }

    public Function<String, List<Car>> getListCarsByMark() {
        return s -> storage.findCarByMark(s);
    }

    public Function<String, List<Car>> getListCarsNotPhoto() {
        return s -> storage.findCar();
    }

    public Function<String, List<Car>> getListAllCars() {
        return s -> storage.allCars();
    }

    public Function<String, List<Car>> getListCarByLastDay() {
        return s -> storage.getListCarByLastDay();
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       String markName = req.getParameter("mark_name");
        HttpSession session = req.getSession();
        String id = "not";
        List<Car> cars = mp
                .get(req.getParameter("action"))
                .apply(markName);
        if (session.getAttribute("userId") != null) {
            id = session.getAttribute("userId").toString();
        }

        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        map.put(id, cars);
        mapper.writeValue(writer, map);
        map.clear();
        writer.flush();

    }
}
