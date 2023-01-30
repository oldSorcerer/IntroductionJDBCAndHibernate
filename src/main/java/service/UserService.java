package service;

import model.User;

import java.util.List;

public interface UserService {

    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, Byte age);

    void removeUserById(Long id);

    List<User> getAllUsers();

    void cleanUsersTable();

}
