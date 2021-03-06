package ru.job4j.datasources;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.model.Country;
import ru.job4j.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DbStore implements DataStore<User> {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DbStore INSTANCE = new DbStore();
    private final static Logger logger = LoggerFactory.getLogger(DbStore.class);

    public DbStore() {
        SOURCE.setDriverClassName("org.postgresql.Driver");
        SOURCE.setUrl("jdbc:postgresql://127.0.0.1:5432/job4j");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("071177");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DbStore getInstance() {
        return INSTANCE;
    }

    @Override
    public User add(User user) {
        String query = "insert into users (name, login, email, data, role, password, country, city ) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            statementCall(ps, user);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update users set  name = ?,  login = ?,  email = ? , data = ? , role = ?, " +
                "password = ? , country = ?, city = ?  where id = ?";
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            statementCall(ps, user);
            ps.setInt(9, user.getId());
            ps.executeUpdate();
        } catch (Exception e) {
           logger.error(e.getMessage(), e);
        }

    }

    @Override
    public void delete(int id) {
        String sql = "delete from users where id = ?";
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);

        }
    }


    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users ";
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = resultSetCall(rs);
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return users;
    }


    public Map<String, Country> getAllCountru() {
        Map<String, Country> countryMap = new HashMap<>();
        String sql = "select cr.name as country ,ct.name as city \n" +
                " from ref_book_city as ct\n" +
                " inner join  ref_book_country as cr on ct.ref_book_country_id = cr.id ";
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String country =  rs.getString("country");
                    String city = rs.getString("city");
                    countryMap.computeIfPresent(country, (key, value) -> value.addCity(city));
                    countryMap.putIfAbsent(country, new Country(country, city));
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return countryMap;
    }


    @Override
    public User findById(int id) {
        User user = null;
        String sql = "select * from users where id=?";
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            {
                if (rs.next()) {
                    user = resultSetCall(rs);
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return user;
    }

    private User resultSetCall(ResultSet rs) throws SQLException {
      User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setLogin(rs.getString("login"));
        user.setEmail(rs.getString("email"));
        user.setData(rs.getTimestamp("data"));
        user.setRole(rs.getString("role"));
        user.setPassword(rs.getString("password"));
        user.setCountry(rs.getString("country"));
        user.setCity(rs.getString("city"));
        return user;
    }

    private PreparedStatement statementCall(PreparedStatement ps, User user) throws SQLException {
        ps.setString(1, user.getName());
        ps.setString(2, user.getLogin());
        ps.setString(3, user.getEmail());
        ps.setTimestamp(4, user.getData());
        ps.setString(5, user.getRole());
        ps.setString(6, user.getPassword());
        ps.setString(7, user.getCountry());
        ps.setString(8, user.getCity());
        return ps;
    }

}
