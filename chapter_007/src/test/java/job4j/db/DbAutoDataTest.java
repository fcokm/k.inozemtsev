package job4j.db;

import org.junit.Test;
import ru.job4j.db.DBStorage;
import ru.job4j.model.User;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;
import java.math.BigDecimal;
import static org.junit.Assert.assertTrue;

public class DbAutoDataTest {

    private final DBStorage storage = DBStorage.getInstance();
    private final DbHelper dbSql = DbHelper.getInstance();
    private final MarkCar markCar = new MarkCar();
    private final CarBody carBody = new CarBody();
    private final CarCategory category = new CarCategory();
    private final Colour  colour =  new Colour();
    private final Year year = new Year();
    private final EngineType engineType = new EngineType();
    private final EngineVolum engineVolum = new EngineVolum();
    private final Transmission transmission = new Transmission();
    private final User user = new User();


    @Test
    public void testAddCarBody() {
        this.carBody.setName("hatchback");
        dbSql.addCarBody(this.carBody);
        assertTrue(storage.getAllCarBody().contains(carBody));
    }

    @Test
    public void testAddCarCategory() {
        this.category.setName("cars");
        dbSql.addCarCategory(this.category);
        assertTrue(storage.getAllCarCategory().contains(category));
    }


    @Test
    public void testAddEngineVolum() {
        BigDecimal vol = new BigDecimal("2.00");
        this.engineVolum.setName(vol);
        dbSql.addEngineVolum( this.engineVolum);
        assertTrue(storage.getAllEngineVolum().contains(engineVolum));
    }

    @Test
    public void testAddEngineType() {
        this.engineType.setName("petrol");
        dbSql.addEngineType( this.engineType);
        assertTrue(storage.getAllTypeEngine().contains(engineType));
    }


    @Test
    public void testAddMarkCar() {
        this.markCar.setName("BMW");
        dbSql.addMarkCar( this.markCar);
        assertTrue(storage.getAllMark().contains(markCar));
    }


    @Test
    public void testAddTransmission() {
        this.transmission.setName("automatic");
        dbSql.addTransmission( this.transmission);
        assertTrue(storage.getAllTransmission().contains(transmission));
    }


    @Test
    public void testAddColour() {
        this.colour.setName("red");
        dbSql.addColour( this.colour);
        assertTrue(storage.getAllColours().contains(colour));
    }

    @Test
    public void testAddYear() {
        this.year.setName("2005");
        dbSql.addYear( this.year);
        assertTrue(storage.getAllYears().contains(year));
    }


    @Test
    public void testAddUser() {
        this.user.setLogin("user");
        this.user.setPassword("pass");
        dbSql.addUser( this.user);
        assertTrue(storage
                .getValidUser("user", "pass")
                .equals(user));
       }

    }

