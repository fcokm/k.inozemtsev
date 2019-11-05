package ru.job4j.model.part;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;


@Data
@NoArgsConstructor
@JsonIgnoreProperties({"markCar", "cars"})
@Entity
@Table(name = "car_model")
public class CarModel {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "car_mark_id")
    private MarkCar markCar;

 }

