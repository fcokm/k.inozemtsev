package ru.job4j.model.part;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "car_category")
public class CarCategory {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "carCategory")
    private List<Car> cars = new ArrayList<>();

}