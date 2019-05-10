package ru.job4j.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.Objects;


/**
 * Class User
 *
 * @author Konstantin
 * @version $Id$
 * @since 0.1
 */
@Data
public class User {
    private int id;
    private String name;
    private String login;
    private String email;
    private Timestamp data;
    private String password;
    private String role;
    private String updateLogin;
    private String country;
    private String city;
}
