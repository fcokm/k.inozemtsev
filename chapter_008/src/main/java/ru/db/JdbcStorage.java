package ru.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.domain.User;

import javax.sql.DataSource;
import java.util.List;


@Component("jdbc")
public class JdbcStorage implements Storage {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcStorage(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User add(User user) {
        jdbcTemplate.update(
                "insert into person (name) values(?)",
                user.getName());
        return user;
    }

    @Override
    public int update(User user) {
        return jdbcTemplate.update(
                "update person set name = ? where id = ?",
                user.getName(), user.getId());
    }


    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update(
                "delete person where id = ?",
                id);

    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(
                "select * from person",
                (rs, rowNum) ->
                        new User(
                                rs.getInt("id"),
                                rs.getString("name")
                        )
        );
    }

}
