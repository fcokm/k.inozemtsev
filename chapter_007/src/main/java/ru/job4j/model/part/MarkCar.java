package ru.job4j.model.part;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.*;

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

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "markCar", fetch = FetchType.EAGER)
  private List<CarModel>  carModels = new ArrayList<>();
}
