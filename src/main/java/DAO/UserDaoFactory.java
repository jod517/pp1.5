package DAO;

import java.io.IOException;

import static utill.GetProp.getPropertyValue;

public class UserDaoFactory {



    public static UserDAO getUserDao() throws IOException {

        if (getPropertyValue("DaoType").equalsIgnoreCase("hibernate")) {
            return UserHibernateDAO.getInstance();
        } else {
            return UserJDBCDao.getInstance();
        }
    }
}
