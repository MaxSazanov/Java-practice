package theory.comparableAndComparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;
import java.util.regex.Pattern;

public class Solution {
    static private final Logger logger = Logger.getLogger(Solution.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("src/theory/logs/log1.log", true);
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new SimpleFormatter());

            FileHandler anotherFileHandler = new FileHandler("src/theory/logs/log2.log", true);

            logger.addHandler(fileHandler);
            logger.addHandler(anotherFileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Pattern regEx = Pattern.compile("\\s*[A-Z][a-z]*:[1-9][0-9]?");
        ArrayList<User> users = new ArrayList<>();

        logger.log(Level.INFO, "the addition of users has started");
        while (console.hasNext(regEx)) {
            String[] info = console.next(regEx).split(":");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            users.add(new User(name, age));
        }
        logger.log(Level.INFO, "all users have been added");
        users.sort(new UserNameComparator().thenComparing(new UserAgeComparator()));
        logger.log(Level.INFO, "users are sorted");
        if (users.isEmpty()) {
            logger.log(Level.WARNING, "user list is empty");
        }

        // Определяем файл в который будем писать лог
        try {
            System.setErr(new PrintStream(new File("log.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
// Выводим сообщения
        System.err.println("Сообщение 1");
        System.err.println("Сообщение 2");
// Выводим сообщение об ошибке
        try {
            throw new Exception("Сообщение об ошибке");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}