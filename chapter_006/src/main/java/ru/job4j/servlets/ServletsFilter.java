package ru.job4j.servlets;

import javax.servlet.*;
import java.io.IOException;

public class ServletsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
      req.setCharacterEncoding("UTF-8");
      resp.setCharacterEncoding("UTF-8");
      resp.setContentType("text/html");
      chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
