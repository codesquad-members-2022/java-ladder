package domain.user;

import java.util.HashMap;

import java.util.InputMismatchException;
import java.util.Map;

public class UserCreator {
    private static final int USERNAME_MAXLENGTH = 5;
    private static final int USERNAME_MINLENGTH = 1;
    private Map<String, User> users;

    public UserCreator(String[] users) {
        this.users = createUserMap(users);
    }

    public static Map<String, User> createUserMap(String[] users) {
        int i = 0;
        Map<String, User> map = new HashMap<>();
        for (String user : users) {
            validateUserName(user);
            map.put(user, new User(user, i));
            i += 2;
        }
        return map;
    }

    private static void validateUserName(String name) {
        if(!(name.length() >= USERNAME_MINLENGTH && name.length() <= USERNAME_MAXLENGTH)) {
            throw new InputMismatchException("이름의 길이를 1자 이상, 5자 이하로 작성해주세요.");
        };
    }
}
