package domain;

import java.util.*;

public class User {
    private static final int USERNAME_MAXLENGTH = 5;
    private static final int USERNAME_MINLENGTH = 1;
    private List<String> users;

    public User(String[] users) {
        if(!validateUserName(users)){
            throw new InputMismatchException("이름의 길이를 1자 이상, 5자 이하로 작성해주세요.");
        }
        this.users = getUserByList(users);
    }

    public List<String> getUsers() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        users.forEach(user -> sb.append(user));
        return sb.toString();
    }

    private List<String> getUserByList(String[] users) {
        List<String> list = new ArrayList<>();

        Arrays.stream(users).forEach(user->{
            list.add(addPadding(user));
        });
        return list;
    }

    private String addPadding(String user) {
        if (user.length() == USERNAME_MAXLENGTH) {
            return user;
        }
        StringBuilder sb = new StringBuilder();
        int whiteSpace = USERNAME_MAXLENGTH - user.length();
        int backSpace = whiteSpace / 2;
        int frontSpace = whiteSpace - backSpace;

        addWhite(frontSpace, sb);
        sb.append(user);
        addWhite(backSpace, sb);

        return sb.toString();
    }

    private StringBuilder addWhite(int count, StringBuilder sb) {
        for (int i = 0; i < count; i++) {
            sb.append(" ");
        }
        return sb;
    }


    private boolean validateUserName(String[] users) {
        return Arrays.stream(users).allMatch((s) -> (s.length() >= USERNAME_MINLENGTH) && (s.length() <= USERNAME_MAXLENGTH));
    }


}
