package service;

import bean.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceJDBCImplTest extends UserServiceTest {

    private final UserService userService = new UserServiceJDBCImpl();

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

//        try {
//            userService.dropUserTable();
//            userService.createUserTable();
//        } catch (Exception e) {
//            fail("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
//        }
    }

    @Test
    void dropUserTable() {
        assertDoesNotThrow(userService::dropUserTable);
//        try {
//            userService.dropUserTable();
//            userService.dropUserTable();
//        } catch (Exception e) {
//            fail("При тестировании удаления таблицы произошло исключение\n" + e.getMessage());
//        }
    }

    @Test
    void saveUser() {
        try {
            User user = userService.getAllUsers().get(0);

            assertEquals(getTestName(), user.getName());
            assertEquals(getTestLastName(), user.getLastName());
            assertEquals(getTestAge(), user.getAge());

//            if (!getTestName().equals(user.getName())
//                    || !getTestLastName().equals(user.getLastName())
//                    || getTestAge() != user.getAge()) {
//                fail("User был некорректно добавлен в базу данных");
//            }
        } catch (Exception e) {
            fail("Во время тестирования сохранения пользователя произошло исключение\n" + e.getMessage());
        }
    }

    @Test
    void removeUserById() {

        userService.removeUserById(1L);
        assertTrue(userService.getAllUsers().isEmpty(), "Проверьте корректность работы метода удаления пользователя");

//        try {
//            userService.removeUserById(1L);
//            assertTrue(userService.getAllUsers().size() != 1, "Проверьте корректность работы метода удаления пользователя");
//        } catch (Exception e) {
//            fail("При тестировании удаления пользователя по id произошло исключение\n" + e.getMessage());
//        }
    }

    @Test
    void getAllUsers() {
        assertFalse(userService.getAllUsers().size() != 1, "Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
//        try {
//
//            assertFalse(userService.getAllUsers().size() != 1, "Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
//
//            List<User> userList = userService.getAllUsers();
//
//            if (userList.size() != 1) {
//                fail("Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
//            }

//        } catch (Exception e) {
//            fail("При попытке достать всех пользователей из базы данных произошло исключение\n" + e.getMessage());
//        }
    }

    @Test
    void clearUserTable() {
        userService.clearUserTable();

        assertTrue(userService.getAllUsers().isEmpty(), "Метод очищения таблицы пользователей реализован не корректно");

//        try {
//
//            userService.clearUserTable();
//
//            assertTrue(userService.getAllUsers().isEmpty(), "Метод очищения таблицы пользователей реализован не корректно");
//
//            if (userService.getAllUsers().size() != 0) {
//                fail("Метод очищения таблицы пользователей реализован не корректно");
//            }
//        } catch (Exception e) {
//            fail("При тестировании очистки таблицы пользователей произошло исключение\n" + e.getMessage());
//        }
    }
}