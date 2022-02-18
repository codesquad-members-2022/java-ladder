package domain;

import java.util.*;

public class User {
    private static final int USERNAME_MAXLENGTH = 5;
    private static final int USERNAME_MINLENGTH = 1;
    private static final String PADDING = " ";
    private String name;
    private int point;


    private User(String user, int point) {
        if (!validateUserName(user)) {
            throw new InputMismatchException("이름의 길이를 1자 이상, 5자 이하로 작성해주세요.");
        }
        this.name = addPadding(user);
        this.point = point;
    }

    public static User createUser(String user, int point) {
        return new User(user, point);
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    private String addPadding(String user) {
        if (user.length() == USERNAME_MAXLENGTH) {
            return user;
        }
        StringBuilder sb = new StringBuilder();
        int whiteSpace = USERNAME_MAXLENGTH - user.length();
        int frontSpace = whiteSpace / 2;
        int backSpace = whiteSpace - frontSpace;

        sb.append(PADDING.repeat(frontSpace));
        sb.append(user);
        sb.append(PADDING.repeat(backSpace));

        return sb.toString();
    }


    private boolean validateUserName(String name) {
        return name.length() >= USERNAME_MINLENGTH && name.length() <= USERNAME_MAXLENGTH;
    }
}
