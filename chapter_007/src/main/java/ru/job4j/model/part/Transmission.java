package ru.job4j.model.part;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import ru.job4j.model.car.Car;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@JsonIgnoreProperties({"cars"})
@Entity
@Table(name = "car_transmission")
public class Transmission {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "transmission")
    private List<Car>  cars = new ArrayList<>();
}

