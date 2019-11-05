package ru.job4j.model.part;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.model.User;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Status;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@Entity
@Table(name="cars_sale")
public class CarSale {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="car_id", nullable=false)
    private Car car;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="category_id", nullable=false)
    private CarCategory category;

    @Column(name = "date_placement")
    private LocalDateTime dateTime;

    @JsonFormat(timezone="UTC", pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Timestamp registrationtime;

    @Column(name = "status")
    private Status status;

    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }
}



