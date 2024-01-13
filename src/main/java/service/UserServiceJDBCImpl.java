package service;

import dao.UserDao;
import dao.UserDaoJDBCImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import bean.User;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceJDBCImpl implements UserService {

    UserDao userDao = new UserDaoJDBCImpl();

    public void createUserTable() {
        userDao.createUserTable();
    }

    public void dropUserTable() {
        userDao.dropUserTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void clearUserTable() {
        userDao.clearUserTable();
    }
}
