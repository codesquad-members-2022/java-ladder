package Repository;

import java.util.HashMap;
import java.util.Map;

import model.User;

public class UserRepository {

    private static final UserRepository instance = new UserRepository();
    private static final Map<Long, User> userStore = new HashMap<>();
    private long sequence = 0L;

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        return instance;
    }

    public User save(User user) {
        user.setID(sequence);
        userStore.put(sequence, user);
        sequence++;
        return user;
    }
}
