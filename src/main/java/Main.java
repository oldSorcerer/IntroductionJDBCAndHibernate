import dao.UserDao;
import dao.UserDaoHibernateImpl;
import dao.UserDaoJDBCImpl;
import model.User;
import service.UserService;
import service.UserServiceHibernateImpl;
import util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        scriptJDBC();
//        scriptHibernate();
//        Util.getSessionFactoryProperties();

        UserService userService = new UserServiceHibernateImpl();

    }

    private static void scriptJDBC() {
        Util.getJDBCConnection();
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUserTable();

        userDao.saveUser("Елена", "Иванова", (byte) 20);
        userDao.saveUser("Павел", "Захаров", (byte) 25);
        userDao.saveUser("Мария", "Польских", (byte) 31);
        userDao.saveUser("Дмитрий", "Васильев", (byte) 38);

        List<User> allUsers = userDao.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
        userDao.clearUserTable();
        userDao.dropUserTable();
    }

    private static void scriptHibernate() {
        Util.getHibernateConnection();

        UserDao userDao = new UserDaoHibernateImpl();
        userDao.createUserTable();

        userDao.saveUser("Елена", "Иванова", (byte) 20);
        userDao.saveUser("Павел", "Захаров", (byte) 25);
        userDao.saveUser("Мария", "Польских", (byte) 31);
        userDao.saveUser("Дмитрий", "Васильев", (byte) 38);

        List<User> allUsers = userDao.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
        userDao.clearUserTable();
        userDao.dropUserTable();

    }
}
