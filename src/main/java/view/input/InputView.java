package view.input;

import domain.user.User;

import java.util.List;

public interface InputView {

    List<User> inputUsers();
    int inputHeight();
    void close();
}
