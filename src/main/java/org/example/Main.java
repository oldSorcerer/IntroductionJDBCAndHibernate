package org.example;

import org.example.service.UserService;
import org.example.service.UserServiceHibernateImpl;
import org.example.service.UserServiceJDBCImpl;
import org.example.util.Util;

public class Main {
    public static void main(String[] args) {
        Util.getJDBCConnection();
        Util.getHibernateConnection();
        Util.getSessionFactoryProperties();
        Util.getSessionFactory();

        script(new UserServiceJDBCImpl());
        script(new UserServiceHibernateImpl());

    }

    private static void script(UserService userService) {

        userService.createUserTable();

        userService.saveUser("Елена", "Иванова", (byte) 20);
        userService.saveUser("Павел", "Захаров", (byte) 25);
        userService.saveUser("Мария", "Польских", (byte) 31);
        userService.saveUser("Дмитрий", "Васильев", (byte) 38);

        System.out.println("----------");
        userService.getAllUsers().forEach(System.out::println);

        userService.removeUserById(1L);

        System.out.println("----------");
        userService.getAllUsers().forEach(System.out::println);

        System.out.println("----------");
        userService.clearUserTable();

        userService.dropUserTable();
    }
}