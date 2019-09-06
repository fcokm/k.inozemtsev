package ru.job4j.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.map.ObjectMapper;
import ru.job4j.db.DBStorage;
import ru.job4j.model.*;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



public class ServiceAutoServlet extends HttpServlet {

   private final DBStorage storage = DBStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String page = req.getParameter("page");
        String requestData = req.getParameter("part");


        if (requestData != null) {
            PrintWriter writer = new PrintWriter(resp.getOutputStream());
            ObjectMapper mapper = new ObjectMapper();
            if (("mark").equals(requestData)) {
                String mark = req.getParameter("it");
                List<CarModel> modelList = storage.findByMark(mark);
                mapper.writeValue(writer, modelList);
                writer.flush();
                return;
            }
            if (("data").equals(requestData)) {
                DataClass data = new DataClass();
                mapper.writeValue(writer, data);
                writer.flush();
                return;
            }

            if (("model").equals(requestData)) {
                List<MarkCar> mark = new ArrayList<>(storage.getAllMark());
                mapper.writeValue(writer, mark);
                writer.flush();
                return;
            }
        }
        String redirectPage = page == null ? "/WEB-INF/pages/main.jsp" : String.format("/WEB-INF/pages/%s", page);
        req.getRequestDispatcher(redirectPage).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = req.getReader();
        Car car = mapper.readValue(reader, Car.class);
        User user = new User();
        if (session.getAttribute("userId") != null) {
            user.setId(Integer.valueOf(session.getAttribute("userId").toString()));
        }
        car.setUser(user);
        car.setRegistrationtime(new Timestamp(System.currentTimeMillis()));
        if (session.getAttribute("path") != null) {
            Path dir = Paths.get(session.getAttribute("path").toString());
            car.setPhoto( Files.readAllBytes(dir));
            Files.delete(dir);
        }

        storage.addOrUpdateCar(car);
        reader.close();
        doGet(req, resp);
    }

    @Data
    @NoArgsConstructor
    private class DataClass {
        private List<EngineVolum> engineVolum = new ArrayList(storage.getAllEngineVolum());
        private List<EngineType> engineType = new ArrayList(storage.getAllTypeEngine());
        private List<Transmission> gearbox = new ArrayList(storage.getAllTransmission());
        private List<MarkCar> mark = new ArrayList(storage.getAllMark());
        private List<CarBody> body = new ArrayList(storage.getAllCarBody());
        private List<CarCategory> category = new ArrayList(storage.getAllCarCategory());
        private List<Year> year = new ArrayList(storage.getAllYears());
        private List<Colour> colour = new ArrayList(storage.getAllColours());

    }
}
