package service;

import dao.UserDao;
import dao.UserDaoHibernateImpl;
import dao.UserDaoJDBCImpl;
import model.User;

import java.util.List;

public class UserServiceHibernateImpl implements UserService {

    private final UserDao userDao = new UserDaoHibernateImpl();

    public void createUsersTable() {
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, Byte age) {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(Long id) {
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
