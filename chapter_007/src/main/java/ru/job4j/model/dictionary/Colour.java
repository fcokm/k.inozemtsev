package ru.job4j.model.dictionary;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import ru.job4j.model.car.Car;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@ToString(exclude = {"cars"})
@EqualsAndHashCode(of = {"id", "name"})
@JsonIgnoreProperties({"cars"})
@Entity
@Table(name = "colour")
public class Colour {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colour")
    private List<Car> cars = new ArrayList<>();
}

