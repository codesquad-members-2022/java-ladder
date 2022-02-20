package model;

public class User {

    public static final int USERNAME_MAX_LENGTH = 5;
    private static final String USERNAME_SHORT_CHARACTER = "..";
    private final String name;
    private Long id;

    public User(String name) {
        name = usernameLengthCheck(name);
        this.name = name;
    }

    private String usernameLengthCheck(String name) {
        if (name.length() > USERNAME_MAX_LENGTH) {
            name = name.substring(0, 3) + USERNAME_SHORT_CHARACTER;
        }
        return name;
    }

    public void setID(long sequence) {
        this.id = sequence;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isSameUsername(String name) {
        return this.name.equals(name);
    }
}
