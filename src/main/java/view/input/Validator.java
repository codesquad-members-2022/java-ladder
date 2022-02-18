package view.input;

import domain.user.User;

import java.util.List;

public interface Validator {

    void validateNumberOfUsers(List<User> users);
    void validateDuplicateUsers(List<User> users);
    void heightValidate(int height);

}
