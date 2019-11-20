package ru.job4j.model.dictionary;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import ru.job4j.model.AbstactCarSpecific;
import ru.job4j.model.car.Car;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@ToString(exclude = {"cars"})
@EqualsAndHashCode(of = {"id", "name"})
@Table(name = "colour")
public class Colour  extends AbstactCarSpecific {
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colour")
    private List<Car> cars = new ArrayList<>();
}

