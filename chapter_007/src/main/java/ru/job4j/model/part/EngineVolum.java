package ru.job4j.model.part;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import ru.job4j.model.car.Car;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@ToString(exclude = {"cars"})
@EqualsAndHashCode(of = {"id", "name"})
@JsonIgnoreProperties({"cars"})
@Entity
@Table(name = "engine_vol")
public class EngineVolum {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "volume")
    private BigDecimal name;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "engineVolum")
    private List<Car>  cars = new ArrayList<>();
}
