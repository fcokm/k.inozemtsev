package ru.job4j.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class ServletsFilter implements Filter {
    private final CopyOnWriteArrayList<String> roleList = new CopyOnWriteArrayList();

    @Override
    public void init(FilterConfig filterConfig) {
        roleList.add("admin");
        roleList.add("user");
        roleList.add("employee");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        if (request.getRequestURI().contains("/auth")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = request.getSession();
            if (isExistsAttribute(session,"login")) {
                ((HttpServletResponse) resp).sendRedirect(String.format("%s/auth", request.getContextPath()));
                return;
            }
            if (isExistsAttribute(session,"roleList")) {
                  session.setAttribute("roleList", roleList);
                if (!session.getAttribute("role").toString().equals("admin")) {
                    session.setAttribute("access", "denied");
                }
            }
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
    }

     boolean isExistsAttribute(HttpSession session, String attr) {
        return  Objects.isNull(session.getAttribute(attr));
     }

}
