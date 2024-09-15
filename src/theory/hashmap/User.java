package theory.hashmap;

import java.time.LocalDate;

public class User {
    String login;
    String password;
    LocalDate createdDate;

    public User(String login, String password, LocalDate createdDate) {
        this.login = login;
        this.password = password;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return login + " " + createdDate.toString();
    }
}
