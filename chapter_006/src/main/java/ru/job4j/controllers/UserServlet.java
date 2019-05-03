package ru.job4j.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.User;
import ru.job4j.validators.Validate;
import ru.job4j.validators.ValidateService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * Class UserServlet
 *
 * @author Konstantin
 * @version $Id$
 * @since 0.1
 */

public class UserServlet extends HttpServlet {
    private final Validate validator = ValidateService.getInstance();
    private final AtomicBoolean isValidUserData = new AtomicBoolean(true);
    private final static Logger logger = LoggerFactory.getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String page = req.getParameter("page");
        if (isValidUserData.get() == false) {
            String jspPath = req.getParameter("jspPath");
            req.setAttribute("isValidlogin", "invalid");
            if (Objects.nonNull(jspPath)) {
                req.getRequestDispatcher(jspPath).forward(req, res);
                return;
            }
        }
        req.getServletContext().setAttribute("userList", this.validator.getAll());
        String redirectPage = page == null ? "/WEB-INF/pages/main.jsp" : String.format("/WEB-INF/pages/%s", page);
        req.getRequestDispatcher(redirectPage).forward(req, res);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User user = getUserFromRequestParam(req);
        if (!validator.load(req.getParameter("action"), user)) {
            isValidUserData.set(false);
            logger.error("User with id  " + req.getParameter("id") +
                    " not found or entered incorrect data!", UserServlet.class);
        } else {
            isValidUserData.set(true);
            logger.info("Operation completed successfully!", UserServlet.class);
        }
       doGet(req, res);
    }


    private User getUserFromRequestParam(HttpServletRequest req) {
        User user = new User();
        if (Objects.nonNull(req.getParameter("id"))) {
            user.setId(Integer.parseInt(req.getParameter("id")));
        }
        user.setName(req.getParameter("name"));
        user.setLogin(req.getParameter("login"));
        user.setUpdateLogin(req.getParameter("loginUpdate"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setRole(req.getParameter("role"));
        user.setCountry(req.getParameter("country"));
        user.setCity(req.getParameter("city"));
        user.setData(new Timestamp(System.currentTimeMillis()));
        return user;
    }

}















