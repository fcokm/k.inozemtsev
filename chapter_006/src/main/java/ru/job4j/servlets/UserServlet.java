package ru.job4j.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/**
 * Class UserServlet
 *
 * @author Konstantin 
 * @version $Id$
 * @since 0.1
 */

public class UserServlet extends HttpServlet {

    private final Map<String, Function<HttpServletRequest, Boolean>> map = new HashMap<>();

    private final ValidateService validator = ValidateService.INSTANCE;

    private final static Logger logger = LoggerFactory.getLogger(UserServlet.class);

    private final  AtomicInteger atomicInt = new AtomicInteger(0);


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter writer = new PrintWriter(res.getOutputStream());
        if (!load(req.getParameter("action"), req)) {
            writer.append("User with id not found or entered incorrect data!\n");
            logger.error("User with id not found or entered incorrect data!");
        } else {
            logger.debug("Operation completed successfully!");
        }
        writer.flush();
        ServletContext context = req.getServletContext();
        context.setAttribute("userList", this.validator.findAll());
        req.getRequestDispatcher("/users").include(req, res);
    }

    @Override
    public void init() {
        map.put("add", this.add());
        map.put("delete", this.delete());
        map.put("update", this.update());
    }

    public boolean load(String key, HttpServletRequest req) {
        return map.get(key).apply(req);
    }

    public Function<HttpServletRequest, Boolean> add() {
        return req -> {
            User user = new User();
            user.setId(atomicInt.incrementAndGet());
            user.setName(req.getParameter("name"));
            user.setLogin(req.getParameter("login"));
            user.setEmail(req.getParameter("email"));
            user.setData(LocalDateTime.now());
            return validator.add(user);
        };
    }

    public Function<HttpServletRequest, Boolean> delete() {
        return req -> {
            User user = new User();
            user.setId(Integer.parseInt(req.getParameter("id")));
            return validator.delete(user.getId());
        };
    }

    public Function<HttpServletRequest, Boolean> update() {
        return req -> {
            User user = new User();
            user.setId(Integer.parseInt(req.getParameter("id")));
            user.setName(req.getParameter("name"));
            user.setLogin(req.getParameter("login"));
            user.setEmail(req.getParameter("email"));
            user.setData(LocalDateTime.now());
            return validator.update(user);
        };
    }
}
