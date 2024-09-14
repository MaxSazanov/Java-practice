package theory.comparableAndComparator;

import java.util.Comparator;

public class UserNameComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.name.compareTo(user2.name);
    }
}
