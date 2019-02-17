package ru.job4j.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



public class UserCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "    <h3>Add New User</h3>\n" +
                "    <div style=\" padding: 15px 5px\">\n" +
                "        <form action=\"user\" method=\"post\">\n" +
                "            Name:<br>\n" +
                "            <input type=\"text\" name=\"name\">\n" +
                "            <br>\n" +
                "            Login:<br>\n" +
                "            <input type=\"text\" name=\"id\">\n" +
                "            <br>\n" +
                "            Email:<br>\n" +
                "            <input type=\"text\" name=\"email\">\n" +
                "            <input type=\"hidden\" name=\"action\" value=\"add\">\n" +
                "            <br><br>\n" +
                "            <input type=\"submit\" value=\"Save\">\n" +
                "        </form>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>");

        writer.flush();
    }
}
