package Service;

import DAO.UserDAO;
import DAO.UserDaoFactory;
import User.User;
import exception.DBException;
import org.hibernate.SessionFactory;
import utill.DBHelper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class UserService {

   private static UserService userService;

    private SessionFactory sessionFactory;

    private static UserDAO userDAO;


    public UserService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(DBHelper.getConfiguration());
        }
        return userService;
    }

    public Optional<User> findByLogin(String login) throws IOException {
        return UserDaoFactory.getUserDao().findByLogin(login);
    }

    public void updateUser(User user) throws IOException {
        UserDaoFactory.getUserDao().updateUser(user);

    }

    public User getUserById(long id) throws IOException {
        return UserDaoFactory.getUserDao().getUserById(id);

    }


    public void deleteUser(Long id) throws IOException {
        UserDaoFactory.getUserDao().deleteUser(id);

    }


          public List<User> getAllUsers() throws SQLException, IOException {
              List<User> list = null;
              list = UserDaoFactory.getUserDao().getAllUsers();
              return list;
    }



   public User getUserByName(String name) throws SQLException, IOException {

       return UserDaoFactory.getUserDao().getUserByName(name);

    }

    public void addUser(User user) throws DBException, SQLException, IOException {
        UserDaoFactory.getUserDao().addUser(user);

    }


}
