package job4j.db;


import ru.job4j.db.DBWrapp;
import ru.job4j.model.User;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;



public class DbHelper extends DBWrapp {

    private static final DbHelper INSTANCE = new DbHelper();

    public static DbHelper getInstance() {
        return INSTANCE;
    }


    public Car addCar(final Car car) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(car);
                    return car;
                }
        );
    }


    public CarBody addCarBody(final CarBody carBody) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(carBody);
                    return carBody;
                }
        );
    }


    public CarCategory addCarCategory(final CarCategory category) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(category);
                    return category;
                }
        );
    }


    public CarModel addCarModel(final CarModel model) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(model);
                    return model;
                }
        );
    }


    public EngineVolum addEngineVolum(final EngineVolum volum) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(volum);
                    return volum;
                }
        );
    }



    public EngineType addEngineType(final EngineType type) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(type);
                    return type;
                }
        );
    }

    public MarkCar addMarkCar(final MarkCar markCar) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(markCar);
                    return markCar;
                }
        );
    }


    public Transmission addTransmission(final Transmission transmission) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(transmission);
                    return transmission;
                }
        );
    }


    public Colour addColour(final Colour colour) {
        return super.tx(
                session -> {
                    session.save(colour);
                    return colour;
                }
        );
    }



    public Year addYear(final Year year) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(year);
                    return year;
                }
        );
    }



    public User addUser(final User user) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(user);
                    return user;
                }
        );
    }


}