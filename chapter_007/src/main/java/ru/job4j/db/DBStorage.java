package ru.job4j.db;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.Query;
import ru.job4j.model.*;
import java.util.Collection;



@Slf4j
public class DBStorage  extends DBStoreWrapper {
    private static final DBStorage INSTANCE = new DBStorage();

    public static DBStorage getInstance() {
        return INSTANCE;
    }


    public Collection<Car> allCars() {
        return super.tx(
                session -> session.createQuery("from Car").list()
        );
    }

    public Car addOrUpdate(final Car car) {
        return super.tx(
                session -> {
                    session.saveOrUpdate(car);
                    return car;
                }
        );
    }

    public Car getCarbyId(final int id) {
        return super.tx(
                session -> {
                    Query query = session.createQuery(
                            "from  Car  where id =:id");
                    query.setParameter("id",id);
                    return (Car)query.uniqueResult();
                }
        );
    }


    public Car delete(final Car car) {
        return super.tx(
                session ->  {
                    session.delete(car);
                    return car;
                }
        );
    }

}