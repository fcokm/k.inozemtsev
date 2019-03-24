package ru.job4j.servlets;

import java.sql.Timestamp;
import java.util.Objects;


/**
 * Class User
 *
 * @author Konstantin
 * @version $Id$
 * @since 0.1
 */

public class User {
    private int id;
    private String name;
    private String login;
    private String email;
    private Timestamp data;
    private String password;
    private String role;
    private String updateLogin;

    public User() {
    }


    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(int id, String login, String password, String role) {
        this.id =id;
        this.login = login;
        this.password = password;
        this.role =role;
    }

    public User(int id, String name, String login, String email, Timestamp data, String password,
                String role, String updateLogin) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.data = data;
        this.password = password;
        this.role = role;
        this.updateLogin = updateLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdateLogin() {
        return updateLogin;
    }

    public void setUpdateLogin(String sessionLogin) {
        this.updateLogin = sessionLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    @Override
    public String toString() {
        return String.format(
                "Id: %d, Name: %s, Login: %s, Email: %s, Data: %s ",
                id, name, login, email, data);

    }
}
