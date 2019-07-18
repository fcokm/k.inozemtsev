package ru.job4j.model.db;


import org.junit.Before;
import org.junit.Test;
import ru.job4j.db.DBStorage;
import ru.job4j.model.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;


public class DBStorageTest {
 private Car car;
 private MarkCar markCar;
 private CarBody carBody;
 private Colour colour;
 private Engine engine;
 private  Transmission transmission;
 private  DBStorage storage;


    @Before
    public void setUp(){
        storage = DBStorage.getInstance();
        car = new Car();
        markCar = new MarkCar();
        carBody = new CarBody();
        colour = new Colour();
        engine = new Engine();
        transmission = new Transmission();
    }

    @Test
    public void whenAddCarThenGetMarkNameByIdCar() {
        markCar.setId(3);
        car.setMarkCar(markCar);
        carBody.setId(2);
        car.setCarBody(carBody);
        engine.setId(1);
        car.setEngine(engine);
        transmission.setId(2);
        car.setTransmission(transmission);
        colour.setId(4);
        car.setColour(colour);
        storage.addOrUpdate(car);
    }

    @Test
    public void whenAddCarThenGetCarEngineName() {
        car.setId(18);
        markCar.setId(3);
        car.setMarkCar(markCar);
        carBody.setId(2);
        car.setCarBody(carBody);
        engine.setId(3);
        car.setEngine(engine);
        transmission.setId(2);
        car.setTransmission(transmission);
        colour.setId(1);
        car.setColour(colour);
        car.setEngine(engine);
        storage.addOrUpdate(car);
        assertThat(storage
                .getCarbyId(18)
                .getEngine()
                .getName(), is("diesel 2.0"));
    }


    @Test
    public void whenDeleteCarByIdThenReturnNull() {
        car.setId(18);
        storage.delete(car);
        assertThat(storage
                .getCarbyId(18)
                , is(nullValue()));
    }
}
