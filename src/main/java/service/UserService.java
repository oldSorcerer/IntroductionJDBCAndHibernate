package service;

import model.User;

import java.util.List;

public interface UserService {

    void createUserTable();

    void dropUserTable();

    void saveUser(String name, String lastName, byte age);

    void removeUserById(Long id);

    List<User> getAllUsers();

    void clearUserTable();

}
