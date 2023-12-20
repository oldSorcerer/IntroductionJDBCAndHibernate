package service;

import model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceHibernateImplTest extends UserServiceTest {

    private final UserService userService = new UserServiceHibernateImpl();

    @BeforeEach
    void testTuning() {
        userService.dropUserTable();
        userService.createUserTable();
        userService.saveUser(getTestName(), getTestLastName(), getTestAge());
    }

    @Test
    void createUserTable() {
        userService.dropUserTable();
        assertDoesNotThrow(userService::createUserTable);
    }

    @Test
    void dropUserTable() {
        assertDoesNotThrow(userService::dropUserTable);
    }

    @Test
    void saveUser() {
        User user = new User(1L, getTestName(), getTestLastName(), getTestAge());

        assertEquals(user, userService.getAllUsers().get(0));
    }

    @Test
    void removeUserById() {
        userService.removeUserById(1L);
        assertTrue(userService.getAllUsers().isEmpty(), "Проверьте корректность работы метода удаления пользователя");
    }

    @Test
    void getAllUsers() {
        assertEquals(1, userService.getAllUsers().size(), "Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
    }

    @Test
    void clearUserTable() {
        userService.clearUserTable();
        assertTrue(userService.getAllUsers().isEmpty(), "Метод очищения таблицы пользователей реализован не корректно");
    }
}