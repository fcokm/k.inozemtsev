package ru.job4j.servlets;



import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JsonServlet extends HttpServlet {

    private final Map<Integer, Person> persons = new ConcurrentHashMap<>();
    private int ids = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, persons);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = req.getReader();
        Person person = mapper.readValue(reader, Person.class);
        reader.close();
        persons.put(this.ids++, person);

    }
}
