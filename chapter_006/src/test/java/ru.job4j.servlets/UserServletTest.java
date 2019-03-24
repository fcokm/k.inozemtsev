package ru.job4j.servlets;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateService.class)
public class UserServletTest {
    private Validate<User> validate;
    private HttpServletRequest req;
    private HttpServletResponse resp;

    @Before
    public void addNewUser() throws ServletException, IOException {
        validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateService.class);
        Mockito.when(ValidateService.getInstance()).thenReturn(validate);
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        when(req.getParameter("action")).thenReturn("add");
        when(req.getParameter("name")).thenReturn("Mike");
        when(req.getParameter("login")).thenReturn("admin");
        when(req.getParameter("role")).thenReturn("user");
        when(req.getParameter("email")).thenReturn("1323@qwe.com");
        when(req.getParameter("password")).thenReturn("1234");
        new UserServlet().doPost(req, resp);
    }

    @Test
    public void whenAddUserThenGetFieldValues() {
        assertThat(validate.getAll().get(0).getName(), is("Mike"));
        assertThat(validate.getAll().get(0).getLogin(), is("admin"));
        assertThat(validate.getAll().get(0).getRole(), is("user"));
        assertThat(validate.getAll().get(0).getEmail(), is("1323@qwe.com"));
        assertThat(validate.getAll().get(0).getPassword(), is("1234"));
    }

    @Test
    public void whenAddUserThenDeleteUserByIdAndReturnFalseResult() throws ServletException, IOException {
        when(req.getParameter("action")).thenReturn("delete");
        when(req.getParameter("id")).thenReturn("0");
        new UserServlet().doPost(req, resp);
        assertFalse(validate.getAll().iterator().hasNext());
    }

    @Test
    public void whenAddUserThenUpdateUserByIdThenGetFieldValues() throws ServletException, IOException {
        when(req.getParameter("action")).thenReturn("update");
        when(req.getParameter("id")).thenReturn("0");
        when(req.getParameter("name")).thenReturn("Jack");
        when(req.getParameter("login")).thenReturn("qwerty");
        when(req.getParameter("role")).thenReturn("admin");
        when(req.getParameter("email")).thenReturn("555@qwe.com");
        when(req.getParameter("password")).thenReturn("4321");
        new UserServlet().doPost(req, resp);
        assertThat(validate.getAll().get(0).getId(), is(0));
        assertThat(validate.getAll().get(0).getName(), is("Jack"));
        assertThat(validate.getAll().get(0).getLogin(), is("qwerty"));
        assertThat(validate.getAll().get(0).getRole(), is("admin"));
        assertThat(validate.getAll().get(0).getEmail(), is("555@qwe.com"));
        assertThat(validate.getAll().get(0).getPassword(), is("4321"));
    }
}
