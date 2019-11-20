package ru.job4j.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.model.car.Car;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

    @Query("select c from Car c  join fetch c.markCar as m where m.name = ?1")
    List<Car>  findCarsByMarkCar(String mark);

    @Query(value = "SELECT * FROM cars  WHERE registration_time > now() - interval '1 day' ", nativeQuery = true)
    List<Car> findCarsByLastDay();

    @Query("select c from Car c  where c.photo is not null")
    List<Car>  findCarsByWithPhoto();

}
