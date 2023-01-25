
import model.User;

import org.junit.jupiter.api.Test;
import service.UserService;
import service.UserServiceJDBCImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceJDBCImplTest {
    private final UserService userService = new UserServiceJDBCImpl();

    private final String testName = "Ivan";
    private final String testLastName = "Ivanov";
    private final byte testAge = 25;

    @Test
    public void createUsersTable() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
        } catch (Exception e) {
            fail("При тестировании создания таблицы пользователей произошло исключение\n" + e.getMessage());
        }
    }

    @Test
    public void dropUsersTable() {
        try {
            userService.dropUsersTable();
            userService.dropUsersTable();
        } catch (Exception e) {
            fail("При тестировании удаления таблицы произошло исключение\n" + e.getMessage());
        }
    }

    @Test
    public void saveUser() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);

            User user = userService.getAllUsers().get(0);

            if (!testName.equals(user.getName())
                    || !testLastName.equals(user.getLastName())
                    || testAge != user.getAge()) {
                fail("User был некорректно добавлен в базу данных");
            }
        } catch (Exception e) {
            fail("Во время тестирования сохранения пользователя произошло исключение\n" + e.getMessage());
        }
    }

    @Test
    public void removeUserById() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            userService.removeUserById(1L);
        } catch (Exception e) {
            fail("При тестировании удаления пользователя по id произошло исключение\n" + e.getMessage());
        }
    }

    @Test
    public void getAllUsers() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            List<User> userList = userService.getAllUsers();

            if (userList.size() != 1) {
                fail("Проверьте корректность работы метода сохранения пользователя/удаления или создания таблицы");
            }
        } catch (Exception e) {
            fail("При попытке достать всех пользователей из базы данных произошло исключение\n" + e.getMessage());
        }
    }

    @Test
    public void cleanUsersTable() {
        try {
            userService.dropUsersTable();
            userService.createUsersTable();
            userService.saveUser(testName, testLastName, testAge);
            userService.cleanUsersTable();

            if (userService.getAllUsers().size() != 0) {
                fail("Метод очищения таблицы пользователей реализован не корректно");
            }
        } catch (Exception e) {
            fail("При тестировании очистки таблицы пользователей произошло исключение\n" + e.getMessage());
        }
    }
}