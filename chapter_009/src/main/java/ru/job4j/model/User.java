package ru.job4j.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import ru.job4j.model.car.Car;
import ru.job4j.model.part.MarkCar;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@JsonIgnoreProperties({"cars", "role"})
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "login")
    private  String login;
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private Boolean active;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="role_id")
    private Role role;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
    private List<Car>  cars = new ArrayList<>();
}
