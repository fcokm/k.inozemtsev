package ru.job4j.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.map.ObjectMapper;
import ru.job4j.db.DBStorage;
import ru.job4j.model.*;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Status;
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


public class AutoServlet extends HttpServlet {

    DBStorage storage = DBStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String page = req.getParameter("page");
        req.getSession().setAttribute("carList", storage.allCars());
        String q = req.getParameter("part");
        if (q != null) {
            if (q.equals("mark")) {
                PrintWriter writer = new PrintWriter(resp.getOutputStream());
                ObjectMapper mapper = new ObjectMapper();
                String mark = req.getParameter("it");
                List<CarModel> modelList = storage.findByMark(mark);
                mapper.writeValue(writer, modelList);
                writer.flush();
                return;
            }
            if (q.equals("data")) {
                PrintWriter writer = new PrintWriter(resp.getOutputStream());
                ObjectMapper mapper = new ObjectMapper();
                DataClass data = new DataClass();
                mapper.writeValue(writer, data);
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
        Car c = mapper.readValue(reader, Car.class);
        User user = new User();
        if (session.getAttribute("userId") != null) {
            user.setId(Integer.valueOf(session.getAttribute("userId").toString()));
        }
        c.setUser(user);
        c.setStatus(Status.isForSale);
        c.setRegistrationtime(new Timestamp(System.currentTimeMillis()));
        String path = session.getAttribute("path").toString();
        System.out.println("Path " + path);
        Path dir = Paths.get(path);
        byte[] bFile = Files.readAllBytes(dir);
        c.setPhoto(bFile);
       // Files.delete(dir);
        storage.addCar(c);
        reader.close();
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
