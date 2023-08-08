import dao.UserDao;
import dao.UserDaoHibernateImpl;
import dao.UserDaoJDBCImpl;
import model.User;
import service.UserService;
import service.UserServiceHibernateImpl;
import service.UserServiceJDBCImpl;
import util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Util.getJDBCConnection();
        Util.getHibernateConnection();
//        Util.getSessionFactoryProperties();
//        Util.getSessionFactory();

        script(new UserServiceJDBCImpl());
        script(new UserServiceHibernateImpl());

    }

    private static void script(UserService userService) {

        userService.createUserTable();

        userService.saveUser("Елена", "Иванова", (byte) 20);
        userService.saveUser("Павел", "Захаров", (byte) 25);
        userService.saveUser("Мария", "Польских", (byte) 31);
        userService.saveUser("Дмитрий", "Васильев", (byte) 38);

        List<User> allUsers = userService.getAllUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
        userService.clearUserTable();
        userService.dropUserTable();
    }
}
