package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.Output;
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

    public List<User> findAllUser() {
        return new ArrayList<>(userStore.values());
    }

    public void clear() {
        userStore.clear();
    }

    public void printUser() {
        Output output = new Output();
        output.printUser(findAllUser());
    }
}
