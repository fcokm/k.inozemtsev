package ru.job4j.repository;


import org.springframework.data.jpa.repository.Query;
import ru.job4j.model.car.Car;
import ru.job4j.model.part.CarModel;

import java.util.List;

public interface CarModelRepository extends CustomRepository<CarModel> {

    @Query("select cm from CarModel cm   join fetch cm.markCar as m where m.name = ?1")
    List<CarModel> findCarModelByMarkCar(String mark);

}
