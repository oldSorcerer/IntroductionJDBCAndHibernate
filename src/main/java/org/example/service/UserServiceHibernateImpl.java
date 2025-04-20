package org.example.service;

import org.example.dao.UserDao;
import org.example.dao.UserDaoHibernateImpl;
import org.example.bean.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceHibernateImpl implements UserService {

    UserDao userDao = new UserDaoHibernateImpl();

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