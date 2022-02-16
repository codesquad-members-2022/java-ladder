package validator;

import java.util.Arrays;

public class InputValidator {
    public static final int MAX_NAME_LENGTH = 5;

    public static boolean validateNameLength(String[] names) {
        return Arrays.stream(names).anyMatch((name) -> name.length() > MAX_NAME_LENGTH);
    }
}
