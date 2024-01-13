package service;

import dao.UserDao;
import dao.UserDaoHibernateImpl;
import bean.User;

import java.util.List;

public class UserServiceHibernateImpl implements UserService {

    private final UserDao userDao = new UserDaoHibernateImpl();

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
