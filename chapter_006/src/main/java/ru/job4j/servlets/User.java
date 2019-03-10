package ru.job4j.servlets;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public User() {
    }

    public User(int id, String name, String login, String email, Timestamp data) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


/*   public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getFormatCreationDate() {
        return DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(data);
    }*/

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
                Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login);
    }

    @Override
    public String toString() {
        return String.format(
                "Id: %d, Name: %s, Login: %s, Email: %s, Data: %s ",
                id, name, login, email, data);

    }
}
