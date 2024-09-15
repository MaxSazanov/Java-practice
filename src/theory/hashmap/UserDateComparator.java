package theory.hashmap;

import java.util.Comparator;

public class UserDateComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.createdDate.compareTo(user2.createdDate);
    }
}
