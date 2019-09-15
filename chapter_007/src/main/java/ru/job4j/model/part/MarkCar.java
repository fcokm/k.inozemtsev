package ru.job4j.model.part;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@ToString(exclude = {"cars"})
@EqualsAndHashCode(of = {"id", "name"})
@Entity
@Table(name = "car_mark")
public class MarkCar {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "markCar")
  private List<CarModel>  carModels = new ArrayList<>();
}
