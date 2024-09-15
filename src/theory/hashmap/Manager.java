package theory.hashmap;

import java.util.*;

public class Manager {
    private HashMap<String, User> users;

    public Manager() {
        users = new HashMap<>();
    }
    public Manager(int numberOfUsers) {
        users = new HashMap<>(numberOfUsers);
    }

    public boolean login(String login, String password) {
        User user = users.get(login);
        return user.password.equals(password);
    }

    public boolean addNewUser(User user) {
        if (users.containsKey(user.login)) {
            return false;
        }
        else {
            users.put(user.login, user);
            return true;
        }
    }

    public boolean deleteUser(String login) {
        return users.remove(login) != null;
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }

    public Collection<User> getAllUsers(String sortCriterion) {
        List<User> sortedUsers = new ArrayList<>(users.values());

        Comparator<User> comparator = null;
        if (sortCriterion.equals("login")) {
            comparator = new UserLoginComparator();
        }
        else if (sortCriterion.equals("date")) {
            comparator = new UserDateComparator();
        }

        sortedUsers.sort(comparator);
        return sortedUsers;
    }


    public boolean editUser(User user) {
        if (!users.containsKey(user.login)) {
            return false;
        }
        User deprecated = users.get(user.login);
        deprecated.createdDate = user.createdDate;
        deprecated.password = user.password;
        return true;
    }
}