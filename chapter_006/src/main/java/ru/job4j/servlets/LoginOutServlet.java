package ru.job4j.servlets;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
         HttpSession session = req.getSession();
        if (session != null) {
            session.invalidate();
        }
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
