package view.input;

import domain.user.User;

import java.util.HashSet;
import java.util.List;

public class ValidatorImpl implements Validator {

    private final int VALID_NAME_LENGTH_MIN = 1;
    private final int VALID_NAME_LENGTH_MAX = 5;

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
    public void validateUserName(User user) {
        String name = user.getName();
        if (hasValidNameLength(name)) {
            return;
        }
        throw new IllegalArgumentException(
                String.format("참가자 이름의 길이는 %d 이상 %d 이하여야합니다.",
                        VALID_NAME_LENGTH_MIN,
                        VALID_NAME_LENGTH_MAX));
    }

    private boolean hasValidNameLength(String name) {
        int nameLength = name.length();
        return VALID_NAME_LENGTH_MIN <= nameLength && nameLength <= VALID_NAME_LENGTH_MAX;
    }

    @Override
    public void validateNumberOfUsers(List<User> users) {
        if (hasValidNumberOfUsers(users)) {
            return;
        }
        throw new IllegalArgumentException(
                String.format("참가자 수의 유효범위는 %d 이상 %d 이하입니다.",
                        VALID_NUMBER_OF_USERS_MIN,
                        VALID_NUMBER_OF_USERS_MAX));
    }

    @Override
    public void validateDuplicateUsers(List<User> users) {
        if (hasNotDuplicateUsers(users)) {
            return;
        }
        throw new IllegalArgumentException("중복되는 회원이 존재합니다.");
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

    private boolean hasNotDuplicateUsers(List<User> users) {
        return numberOfUsers(users) == numberOfDifferentUsers(users);
    }

    private int numberOfUsers(List<User> users) {
        return users.size();
    }

    private int numberOfDifferentUsers(List<User> users) {
        return new HashSet<>(users).size();
    }

    private boolean hasValidNumberOfUsers(List<User> users) {
        int numberOfUsers = users.size();
        return VALID_NUMBER_OF_USERS_MIN <= numberOfUsers && numberOfUsers < VALID_NUMBER_OF_USERS_MAX;
    }

    private boolean isValidHeight(int height) {
        return VALID_HEIGHT_MIN <= height && height < VALID_HEIGHT_MAX;
    }
}
