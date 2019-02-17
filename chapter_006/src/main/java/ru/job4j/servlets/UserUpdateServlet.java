package ru.job4j.servlets;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ServletContext context = req.getServletContext();
        User user = (User) context.getAttribute("user");
        writer.append("<!DOCTYPE html>" +
                "<html>" +
                "<body>" +
                "    <h3>Input user data</h3>" +
                "    <div style= padding: 15px 5px>" +
                "        <form action=\"user\" method=\"post\">\n" +
                "     <table>" +
                "     <tr><td></td><td><input type='hidden' name='id' value='" + user.getId() + "'/></td></tr>" +
                "      <tr><td>Name:</td><td><input type='text' name='name' value='" + user.getName() + "'/></td></tr>" +
                "      <tr><td>Login:</td><td><input type='text' name='login' value='" + user.getLogin() + "'/></td></tr>" +
                "     <tr><td>Email:</td><td><input type='text' name='email' value='" + user.getEmail() + "'/></td></tr>" +
                "     <tr><td colspan='2'><input type='submit' value='Edit & Save'/></td></tr>" +
                "      </table>" +
                "      <input type=\"hidden\" name=\"action\" value=\"update\">\n" +
                "        </form>\n" +
                "   </div>" +
                "  </body>" +
                "</html>");
        writer.flush();
    }

}
