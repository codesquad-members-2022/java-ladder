package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.WrongInputException;
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
        userDuplicateCheck(user);
        user.setID(sequence);
        userStore.put(sequence, user);
        sequence++;
        return user;
    }

    private void userDuplicateCheck(User user) {
        for (var i : findAllUser()) {
            validateUser(user, i);
        }
    }

    private void validateUser(User user, User i) {
        if (i.isSameUsername(user.toString())) {
            userStore.clear();
            throw new WrongInputException("중복된 유저가 존재합니다.");
        }
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
