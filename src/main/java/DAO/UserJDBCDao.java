package DAO;

import User.User;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserJDBCDao implements UserDAO {

    private Connection connection;

    private static UserJDBCDao instance = new UserJDBCDao();

    public UserJDBCDao(Connection connection) {
        this.connection = connection;
    }

    public UserJDBCDao() {
    }

    public static UserJDBCDao getInstance() {
        return instance;
    }

    public Optional<User> findByLogin(String login) {
        return null;
    }
    public void updateUser(User user) {
        String sql = "UPDATE user SET name = ?, login = ?, password = ? WHERE id = ?";
        try (PreparedStatement preStmt = connection.prepareStatement(sql)) {

            preStmt.setString(1, user.getName());
            preStmt.setString(2, user.getLogin());
            preStmt.setString(3, user.getPassword());
            preStmt.setLong(4, user.getId());
            preStmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public User getUserById(long ID) {

        User user = new User();

        try (Statement stmt = connection.createStatement()) {

            stmt.execute("SELECT * FROM user WHERE id='" + ID + "'");
            ResultSet result = stmt.getResultSet();

            result.next();

            user.setId(ID);
            user.setName(result.getString("name"));
            user.setLogin(result.getString("login"));
            user.setPassword(result.getString("password"));

            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    public void deleteUser(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from user where id= ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public @NotNull
    List<User> getAllUsers() throws SQLException {

        try (Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery("SELECT * FROM user ")
        ) {
            List<User> usersList = new ArrayList<>();

            while (result.next()) {
                User user = new User(
                        result.getLong("id"),
                        result.getString("name"),
                        result.getString("login"),
                        result.getString("password")

                );
                usersList.add(user);
            }
            return (usersList.isEmpty()) ? Collections.emptyList() : usersList;
        }
    }

    private @Nullable
    User getClientBySqlQuery(final String sql, final String... args)
            throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                stmt.setString(i + 1, args[i]);
            }
            try (ResultSet result = stmt.executeQuery()) {
                User user = null;
                if (result.next()) {
                    user = new User(
                            result.getLong("id"),
                            result.getString("name"),
                            result.getString("login"),
                            result.getString("password")
                    );
                }
                return user;
            }
        }
    }

    public @Nullable
    User getUserByName(final String name) throws SQLException {
        return getClientBySqlQuery("SELECT * FROM user WHERE name=?", name);
    }


    public void addUser(User user) throws SQLException {
        int updatesCount = 0;
        if (getUserByName(user.getName()) == null) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO user (name, login, password, role) values (?, ?, ?, ?)")
            ) {
                stmt.setString(1, user.getName());
                stmt.setString(2, user.getLogin());
                stmt.setString(3, user.getPassword());
                stmt.setString(4, user.getRole());
                updatesCount = stmt.executeUpdate();
            }
        }
        if (updatesCount != 1) {
            throw new IllegalStateException("Error while adding user!");
        }
    }



}
