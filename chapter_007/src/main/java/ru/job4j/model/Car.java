package ru.job4j.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name="body_id", nullable=false)
    private CarBody carBody;
    @ManyToOne
    @JoinColumn(name="colour_id", nullable=false)
    private Colour colour;
    @ManyToOne
    @JoinColumn(name="engine_id", nullable=false)
    private Engine engine;
    @ManyToOne
    @JoinColumn(name="mark_id", nullable=false)
    private  MarkCar markCar;
    @ManyToOne
    @JoinColumn(name="transmission_id", nullable=false)
    private Transmission transmission;


    @Override
    public String toString() {
        return String.format("%d %s %s  %s %s",
                id
                , colour.getName()
                , markCar.getName()
                , carBody.getBody()
                , engine.getName()
                , transmission.getType());
    }

}

}
