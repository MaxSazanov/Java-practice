package theory.comparableAndComparator;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Pattern regEx = Pattern.compile("\\s*[A-Z][a-z]*:[1-9][0-9]?");
        ArrayList<User> users = new ArrayList<>();
        while (console.hasNext(regEx)) {
            String str = console.next(regEx);
            String name = str.split(":")[0];
            int age = Integer.parseInt(str.split(":")[1]);
            users.add(new User(name, age));
        }
        users.sort(new UserNameComparator());
        System.out.println(users);
        users.sort(new UserAgeComparator());
        System.out.println(users);
    }
}