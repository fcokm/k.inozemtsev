package ru.job4j.servlets;

import org.codehaus.jackson.map.ObjectMapper;
import ru.job4j.datasources.DbStore;
import ru.job4j.model.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class JsonContryServlet extends HttpServlet {
    private final DbStore dataStore = DbStore.getInstance();
    private final Map<String, Country> countryMap = new ConcurrentHashMap<>();

    @Override
    public void init() {
        countryMap.putAll(dataStore.getAllCountru());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<String>> result1 = countryMap
                .values()
                .stream()
                .collect(
                Collectors.toMap(Country::getName, Country::getCityList));
        mapper.writeValue(writer, result1);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String reqParameter = req.getParameter("country");
        List<String> cityList = countryMap
                .get(reqParameter)
                .getCityList();

        String select = " ";

        for (String value : cityList) {
            select += " <select id=\"city\" name=\"city\">\n" +
                    "                <option> " + value + " </option>\n" +
                    "            </select>\n ";
        }
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        mapper.writeValue(writer, select);
        writer.flush();
    }
}
