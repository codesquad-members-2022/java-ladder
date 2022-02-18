package app.jinan159.ladder.validation;

import app.jinan159.ladder.config.GameConfig;

public class InputValidator {

    private final String ALERT_VALIDATION_FAILED = "(주의) 입력하신 항목을 다시한번 확인해 주세요.";

    private final GameConfig config;

    private InputValidator(GameConfig config) {
        this.config = config;
    }

    public static InputValidator createWithConfig(GameConfig config) {
        return new InputValidator(config);
    }

    public void validateIsPositive(int input) throws IllegalArgumentException {
        if (input <= 0) {
            throw new IllegalArgumentException(ALERT_VALIDATION_FAILED);
        }
    }

    public void validateNames(String[] names) throws IllegalArgumentException {
        if (names == null) throw new IllegalArgumentException(ALERT_VALIDATION_FAILED);

        for (String name : names) {
            validateNamesLength(name);
        }
    }

    private void validateNamesLength(String input) throws IllegalArgumentException {
        if (input.length() > config.getNameLength()) {
            throw new IllegalArgumentException(ALERT_VALIDATION_FAILED);
        }
    }

}
