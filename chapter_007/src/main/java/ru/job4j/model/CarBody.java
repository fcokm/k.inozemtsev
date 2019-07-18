package ru.job4j.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "car_body")
public class CarBody {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "body")
    private String body;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carBody")
    private Set<Car> carSet = new HashSet();
}