package ru.job4j.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;


public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ServletContext context = req.getServletContext();
        Collection<User> users = (Collection<User>) context.getAttribute("userList");
        writer.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <style>\n" +
                "        table, th, td {\n" +
                "            border: 1px solid black;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n");
        writer.append("<div style=\" padding: 15px 5px\">\n" +
                "    <h2>Users List</h2>\n" +
                "<table>\n" +
                "    <tr>\n" +
                "        <th>Id</th>\n" +
                "        <th>Name</th>\n" +
                "        <th>Login</th>\n" +
                "        <th>Email</th>\n" +
                "        <th>Data</th>\n" +
                "        <th>Edit</th>\n" +
                "        <th>Delete</th>\n" +
                "    </tr>\n");
     if(users != null) {
         users.forEach(user -> {
             context.setAttribute("user", user);
             writer.append("  <tr>\n" +
                     "        <td> " + user.getId() + " </td>\n" +
                     "        <td> " + user.getName() + " </td>\n" +
                     "        <td>" + user.getLogin() + "</td>\n" +
                     "        <td>" + user.getEmail() + "</td>\n" +
                     "        <td>" + user.getData() + "</td>\n" +
                     "        <td>\n" +
                     "            <form action=\"/update?id = " + user.getId() + "method=\"get\">\n" +
                     "                <button name=\"id\" type=\"submit\" value=\"\">Edit </button>\n" +
                     "            </form>\n" +
                     "        </td>\n" +

                     "        <td>\n" +
                     "            <form action=\"user\" method=\"post\">\n" +
                     "            <input type=\"hidden\" name=\"id\" value=" + user.getId() + ">\n" +
                     "            <input type=\"hidden\" name=\"action\" value=\"delete\">\n" +
                     "                <button name=\"id\" type=\"submit\" value=\"\">Delete </button>\n" +
                     "            </form>\n" +
                     "        </td>\n" +

                     "    </tr>\n");
         });
     }
        writer.append("</table>\n" +
                "</div>\n");
        writer.append("<a href='create'>Add New User</a>");
        writer.append("</body>\n" +
                "</html>");
        writer.flush();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }

}
