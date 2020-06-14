package DAO;

import User.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDAO  {

    void updateUser(User user);
    User getUserById(long id);
    void deleteUser(Long id);
    List<User> getAllUsers() throws SQLException;
    User getUserByName(String name) throws SQLException;
    void addUser(User user) throws SQLException;
    public Optional<User> findByLogin(String login);


}
