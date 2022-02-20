package ladder.domain;

public class User {
    public static final int MAX_NAME_LIMIT = 5;
    public String name;
    public boolean nameLimitExcess = false;

    public User(String inputName) {
        if (inputName.length() <= MAX_NAME_LIMIT) {
            name = inputName;
            return;
        }
        nameLimitExcess = true;
        name = inputName.substring(0, 5);
    }
}
