package ru.job4j.model.part;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import ru.job4j.model.AbstactCarSpecific;
import ru.job4j.model.car.Car;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@JsonIgnoreProperties({"cars"})
@EqualsAndHashCode(of = {"id", "name"})
@Entity
@Table(name = "engine_vol")
public class EngineVolum  extends AbstactCarSpecific{

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "engineVolum")
    private List<Car>  cars = new ArrayList<>();
}
