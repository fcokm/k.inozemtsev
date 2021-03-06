package ru.job4j.model.part;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;


@Data
@NoArgsConstructor
@JsonIgnoreProperties({"cars"})
@Entity
@Table(name="car_engine")
public class Engine {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "power")
    private short power;
    @ManyToOne
    @JoinColumn(name="type_id")
    private EngineType type;
    @ManyToOne
    @JoinColumn(name="volume_id")
    private EngineVolum volum;
}
