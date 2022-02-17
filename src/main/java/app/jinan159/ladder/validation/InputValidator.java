package app.jinan159.ladder.validation;

import app.jinan159.ladder.LadderGame;

public class InputValidator {

    private final static String ALERT_VALIDATION_FAILED = "(주의) 입력하신 항목을 다시한번 확인해 주세요.";

    public static void validateIsPositive(int input) throws IllegalArgumentException {
        if (input <= 0) {
            throw new IllegalArgumentException(ALERT_VALIDATION_FAILED);
        }
    }

    public static void validateNames(String[] names) throws IllegalArgumentException {
        for (String name : names) {
            validateNamesLength(name);
        }
    }

    private static void validateNamesLength(String input) throws IllegalArgumentException {
        if (input.length() > LadderGame.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ALERT_VALIDATION_FAILED);
        }
    }

}
