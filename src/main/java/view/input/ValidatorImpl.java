package view.input;

public class ValidatorImpl implements Validator {

    private final int VALID_NUMBER_OF_USERS_MIN = 2;
    private final int VALID_NUMBER_OF_USERS_MAX = 12;

    private final int VALID_HEIGHT_MIN = 1;
    private final int VALID_HEIGHT_MAX = 12;

    private static final ValidatorImpl instance = new ValidatorImpl();

    private ValidatorImpl() {}

    public static ValidatorImpl getInstance() {
        return instance;
    }

    @Override
    public void validateNumberOfUsers(int numberOfUsers) {
        if (isValidNumberOfUsers(numberOfUsers)) {
            return;
        }
        throw new IllegalArgumentException(
                String.format("참가자 수의 유효범위는 %d 이상 %d 이하입니다.",
                        VALID_NUMBER_OF_USERS_MIN,
                        VALID_NUMBER_OF_USERS_MAX));
    }

    @Override
    public void heightValidate(int height) {
        if (isValidHeight(height)) {
            return;
        }
        throw new IllegalArgumentException(
                String.format("높이의 유효범위는 %d 이상 %d 이하입니다.",
                        VALID_HEIGHT_MIN,
                        VALID_HEIGHT_MAX));
    }

    private boolean isValidNumberOfUsers(int numberOfUsers) {
        return VALID_NUMBER_OF_USERS_MIN <= numberOfUsers && numberOfUsers < VALID_NUMBER_OF_USERS_MAX;
    }

    private boolean isValidHeight(int height) {
        return VALID_HEIGHT_MIN <= height && height < VALID_HEIGHT_MAX;
    }
}
