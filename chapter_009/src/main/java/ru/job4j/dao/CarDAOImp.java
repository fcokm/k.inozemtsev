package ru.job4j.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.job4j.model.User;
import ru.job4j.model.car.Car;
import ru.job4j.model.dictionary.Colour;
import ru.job4j.model.dictionary.Year;
import ru.job4j.model.part.*;
import java.util.List;


@Repository
public class CarDAOImp implements CarDAO {


    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public List<Car> allCars() {
        return getSession().createQuery("from Car").list();

    }
    
    public List<MarkCar> getAllMark() {
        return getSession().createQuery("from MarkCar").list();

    }

    public List<EngineType> getAllTypeEngine() {
        return getSession().createQuery("from EngineType").list();
    }


    public List<EngineVolum> getAllEngineVolum() {
        return getSession().createQuery("from EngineVolum").list();

    }


    public List<Transmission> getAllTransmission() {
        return getSession().createQuery("from Transmission").list();

    }

    public List<CarBody> getAllCarBody() {
        return getSession().createQuery("from CarBody").list();

    }


    public List<Year> getAllYears() {
        return getSession().createQuery("from Year").list();

    }


    public List<CarCategory> getAllCarCategory() {
        return getSession().createQuery("from CarCategory").list();

    }

    public List<Colour> getAllColours() {
        return getSession().createQuery("from Colour").list();

    }


    public Car addOrUpdateCar(final Car car) {
        getSession().saveOrUpdate(car);
        return car;
    }

    public List<CarModel> findByMark(final String mark) {
        Query query = getSession().createQuery(
                "from  MarkCar  where name =:name");
        query.setParameter("name", mark);
        MarkCar c = (MarkCar) query.uniqueResult();
        return c.getCarModels();
    }


    public List<Car> findCar() {
        Query query = getSession().createQuery(
                "from  Car  where photo is not null");
        return query.list();

    }


    public List<Car> getListCarByLastDay() {

        List<Car> cars = getSession()
                .createNativeQuery("SELECT * FROM cars " +
                                " WHERE registration_time > now() - interval '1 day' ",
                        Car.class)
                .getResultList();
        return cars;
    }


    public List<Car> findCarByMark(final String mark) {
        String hql = " select * from cars c"
                + " inner join  car_mark m on m.id = c.mark_id "
                + " where m.name = :mark ";
        Query query = getSession().createSQLQuery(hql)
                .addEntity(Car.class)
                .setParameter("mark", mark);
        return query.list();

    }


    public User getValidUser(final String login, final String password) {
        String hql = "from User u " +
                "where " +
                "u.login = ?1 " +
                "and u.password = ?2";

        User user = (User) getSession()
                .createQuery(hql)
                .setParameter(1, login)
                .setParameter(2, password)
                .uniqueResult();
        return user;

    }

}
