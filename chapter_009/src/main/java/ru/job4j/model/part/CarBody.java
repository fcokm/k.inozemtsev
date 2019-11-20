package ru.job4j.model.part;

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


@Data
@Entity
@ToString(exclude = {"cars"})
@EqualsAndHashCode(of = {"id", "name"})
@Table(name = "car_body")
public class CarBody extends AbstactCarSpecific {
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "carBody")
    private List<Car> cars = new ArrayList<>();
}
