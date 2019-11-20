package ru.job4j.model.part;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.job4j.model.AbstactCarSpecific;
import javax.persistence.*;



@ToString(exclude = {"cars"})
@EqualsAndHashCode(of = {"id", "name"})
@Entity
@Table(name = "car_model")
public class CarModel extends AbstactCarSpecific {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "car_mark_id")
    @Getter
    private MarkCar markCar;

 }

