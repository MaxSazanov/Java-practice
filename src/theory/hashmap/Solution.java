package theory.hashmap;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.addNewUser(new User("Igor", "12345678", LocalDate.of(2019, 6, 14)));
        manager.addNewUser(new User("Max", "87654321", LocalDate.of(2016, 1, 5)));
        manager.addNewUser(new User("Dima", "123456", LocalDate.of(2014, 9, 24)));

        System.out.println(manager.getAllUsers());
        System.out.println(manager.getAllUsers("login"));
        System.out.println(manager.getAllUsers("date"));

        System.out.println("login correct user: " + manager.login("Igor", "12345678"));
        System.out.println("login with incorrect password: " + manager.login("Igor", "1234asdf"));
        System.out.println("delete correct user: " + manager.deleteUser("Igor"));
        System.out.println("delete incorrect user: " + manager.deleteUser("tiger"));
    }
}
