package ru.job4j.model.part;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.job4j.model.AbstactCarSpecific;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@ToString(exclude = {"cars"})
@EqualsAndHashCode(of = {"id", "name"})
@Table(name = "car_mark")
public class MarkCar extends AbstactCarSpecific {
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "markCar", fetch = FetchType.EAGER)
  private List<CarModel>  carModels = new ArrayList<>();

}
