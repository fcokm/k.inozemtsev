package ru.job4j.db;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ru.job4j.model.*;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;
import ru.job4j.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Slf4j
public class DBStorage extends DBWrapp {
    private static final DBStorage INSTANCE = new DBStorage();

    public static DBStorage getInstance() {
        return INSTANCE;
    }

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    public Collection<Car> allCars() {
        return super.tx(
                session -> session.createQuery("from Car").list()
        );
    }


    public Collection<MarkCar> getAllMark() {
        return super.tx(
                session -> session.createQuery("from MarkCar").list()
        );
    }


    public Collection<EngineType> getAllTypeEngine() {
        return super.tx(
                session -> session.createQuery("from EngineType").list()
        );
    }


    public Collection<EngineVolum> getAllEngineVolum() {
        return super.tx(
                session -> session.createQuery("from EngineVolum").list()
        );
    }


    public Collection<Transmission> getAllTransmission() {
        return super.tx(
                session -> session.createQuery("from Transmission").list()
        );
    }

    public Collection<CarBody> getAllCarBody() {
        return super.tx(
                session -> session.createQuery("from CarBody").list()
        );
    }


    public Collection<Year> getAllYears() {
        return super.tx(
                session -> session.createQuery("from Year").list()
        );
    }


    public Collection<CarCategory> getAllCarCategory() {
        return super.tx(
                session -> session.createQuery("from CarCategory").list()
        );
    }

    public Collection<Colour> getAllColours() {
        return super.tx(
                session -> session.createQuery("from Colour").list()
        );
    }


    public Car addCar(final Car car) {
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