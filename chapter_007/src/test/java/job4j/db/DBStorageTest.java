package job4j.db;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.job4j.db.DBStorage;
import ru.job4j.model.User;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;


@Slf4j
public class DBStorageTest {
    private final DBStorage storage = DBStorage.getInstance();
    private final Car car;

   @BeforeClass
   public static void setUp() {
        DbHelper dbSql = DbHelper.getInstance();
        Car car = new Car();
        MarkCar markCar = new MarkCar();
        CarModel carModel = new CarModel();
        CarBody carBody = new CarBody();
        CarCategory category = new CarCategory();
        EngineType engineType = new EngineType();
        EngineVolum engineVolum = new EngineVolum();
        Transmission transmission = new Transmission();
        Colour  colour =  new Colour();
        Year year = new Year();
        User user = new User();
        carBody.setName("hatchback");
        category.setName("cars");
        carModel.setName("X5");
        engineVolum.setName(new BigDecimal("2.00"));
        engineType.setName("petrol");
        markCar.setName("BMW");
        transmission.setName("automatic");
        colour.setName("red");
        year.setName("2005");
        user.setLogin("user");
        user.setPassword("pass");
        dbSql.addCarBody(carBody);
        dbSql.addCarCategory(category);
        dbSql.addCarModel(carModel);
        dbSql.addEngineVolum(engineVolum);
        dbSql.addEngineType(engineType);
        dbSql.addMarkCar(markCar);
        dbSql.addTransmission(transmission);
        dbSql.addColour(colour);
        dbSql.addYear(year);
        dbSql.addUser(user);
        car.setMarkCar(markCar);
        car.setCarModel(carModel);
        car.setCarBody(carBody);
        car.setEngineType(engineType);
        car.setEngineVolum(engineVolum);
        car.setTransmission(transmission);
        car.setUser(user);
        car.setMileage(1000);
        car.setPrice(new BigDecimal("300000.00"));
        car.setCarCategory(category);
        car.setColour(colour);
        car.setYear(year);
        car.setRegistrationtime(new Timestamp(System.currentTimeMillis()));
        dbSql.addCar(car);
    }


    public DBStorageTest() {
        car = storage.findCarById(1);
        storage.addOrUpdateCar(car);
    }

    @Test
    public  void whenAddCarThenContainsCar() {
         assertTrue(storage.allCars().contains(car));
    }


    @Test
    public   void whenFindCarByPhotoThenReturnEmptyList() {
        assertThat(storage.findCarByPhoto()
                , is(Collections.EMPTY_LIST));
    }

    @Test
    public   void whenSetPhotoCarThenFindCarByPhotoReturnTrue() {
        try (InputStream is = DBStorageTest.class
                .getClassLoader().getResourceAsStream
                ("auto.jpeg")) {
            byte[] bytes = IOUtils.toByteArray(is);
             car.setPhoto(bytes);
            storage.addOrUpdateCar(car);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        assertTrue(storage.findCarByPhoto().contains(car));
    }


    @Test
    public void whenSetRegTimeNowThenContainsCar() {
        assertTrue(storage.getListCarByLastDay().contains(car));
    }

    @Test
    public void whenSetRegTimeNowMinusFiveDaysThenReturnEmptyList() {
        LocalDateTime lastDate  = LocalDateTime
                .from(LocalDateTime
                        .now()).minusDays(5);
        car.setRegistrationtime(Timestamp.valueOf(lastDate));
        storage.addOrUpdateCar(car);
        assertThat(storage.getListCarByLastDay()
                , is(Collections.EMPTY_LIST));
    }


    @Test
    public  void whenfindCarByMarkThenReturnTrue() {
        assertTrue(storage.findCarByMark("BMW").contains(car));
    }

}
