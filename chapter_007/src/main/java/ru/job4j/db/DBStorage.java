package ru.job4j.db;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Query;
import ru.job4j.model.*;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Status;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@Slf4j
public class DBStorage extends DBWrapp {
    private static final DBStorage INSTANCE = new DBStorage();

    public static DBStorage getInstance() {
        return INSTANCE;
    }



    public Car findCarById(final int id) {
        return super.tx(
                session -> {
                    Car car = session.get(Car.class, id);
                    return car;
                }
        );
    }

    public List<Car> allCars() {
        return super.tx(
                session -> session.createQuery("from Car").list()
        );
    }

    public List<MarkCar> getAllMark() {
        return super.tx(
                session -> session.createQuery("from MarkCar").list()
        );
    }

    public List<EngineType> getAllTypeEngine() {
        return super.tx(
                session -> session.createQuery("from EngineType").list()
        );
    }


    public List<EngineVolum> getAllEngineVolum() {
        return super.tx(
                session -> session.createQuery("from EngineVolum").list()
        );
    }


    public List<Transmission> getAllTransmission() {
        return super.tx(
                session -> session.createQuery("from Transmission").list()
        );
    }

    public List<CarBody> getAllCarBody() {
        return super.tx(
                session -> session.createQuery("from CarBody").list()
        );
    }


    public List<Year> getAllYears() {
        return super.tx(
                session -> session.createQuery("from Year").list()
        );
    }


    public List<CarCategory> getAllCarCategory() {
        return super.tx(
                session -> session.createQuery("from CarCategory").list()
        );
    }

    public List<Colour> getAllColours() {
        return super.tx(
                session -> session.createQuery("from Colour").list()
        );
    }


    public Car addOrUpdateCar(final Car car) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(car);
                    return car;
                }
        );
    }

    public List<CarModel> findByMark(final String mark) {
        return super.tx(
                session -> {
                    Query query = session.createQuery(
                            "from  MarkCar  where name =:name");
                    query.setParameter("name", mark);
                    MarkCar c = (MarkCar) query.uniqueResult();
                    return c.getCarModels();
                }
        );
    }


    public List<Car> findCarByPhoto() {
        return super.tx(
                session -> {
                    Query query = session.createQuery(
                            "from  Car  where photo is not null");
                    return query.list();
                }
        );
    }


    public List<Car> getListCarByLastDay() {
        String hql = "select  c from Car as c "
                + "  where c.registrationtime > ?1";
        return super.tx(
                session -> {
                    LocalDateTime lastDate  = LocalDateTime
                            .from(LocalDateTime
                                    .now()).minusDays(1);
                    Timestamp lastTms = Timestamp.valueOf(lastDate);
                    Query query = session
                            .createQuery(hql)
                            .setParameter(1, lastTms);
                    return query.list();
                }
        );
    }


    public List<Car> findCarByMark(final String mark) {
        String hql = "select  c from Car as c inner join c.markCar m "
                + "  where m.name = ?1";
        return super.tx(
                session -> {
                    Query query = session
                            .createQuery(hql)
                            .setParameter(1, mark);
                    return query.list();
                }
        );
    }


    public User getValidUser(final String login, final String password) {
        String hql = "from User u " +
                "where " +
                "u.login = ?1 " +
                "and u.password = ?2";
        return super.tx(
                session -> {
                    User user = (User) session
                            .createQuery(hql)
                            .setParameter(1, login)
                            .setParameter(2, password)
                            .uniqueResult();
                    return user;
                }
        );
    }

}