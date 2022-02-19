public class User {
    public static final int MAX_NAME_LIMIT = 5;
    String name;
    boolean nameLimitExcess = false;

    User(String inputName) {
        if (inputName.length() <= MAX_NAME_LIMIT) {
            name = inputName;
            return;
        }
        nameLimitExcess = true;
        name = inputName.substring(0, 5);
    }
}
