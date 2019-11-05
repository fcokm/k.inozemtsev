package ru.job4j.model.part;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "car_mark")
public class MarkCar {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "markCar", fetch = FetchType.EAGER)
  private List<CarModel>  carModels = new ArrayList<>();
}
