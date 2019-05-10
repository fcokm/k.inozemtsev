package ru.job4j.servlets;


import ru.job4j.model.User;
import ru.job4j.validators.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    private final ValidateService validator = ValidateService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = validator.getValidUser(login, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("role", user.getRole());
            session.setAttribute("login", user.getLogin());
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
            return;
        } else {
            req.setAttribute("error", "invalid");
            doGet(req, resp);
        }
    }
}
