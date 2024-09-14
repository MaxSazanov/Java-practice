package theory.comparableAndComparator;

import java.util.Comparator;

public class UserAgeComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.age.compareTo(user2.age);
    }
}
