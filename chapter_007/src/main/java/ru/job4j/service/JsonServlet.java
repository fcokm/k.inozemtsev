package ru.job4j.service;

import org.codehaus.jackson.map.ObjectMapper;
import ru.job4j.db.DBStorage;
import ru.job4j.model.Item;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;


public class JsonServlet extends HttpServlet {

    DBStorage storage = DBStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, storage.allItem());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BufferedReader reader = req.getReader();
        Item item = mapper.readValue(reader, Item.class);
        item.setCreated(new Timestamp(System.currentTimeMillis()));
        storage.addOrUpdate(item);
        reader.close();
    }

}
