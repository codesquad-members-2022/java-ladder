package model.game;

import java.util.stream.Stream;

import exception.WrongInputException;
import io.Input;
import io.Output;
import model.Ladder;
import model.User;
import repository.UserRepository;

public class LadderGame {

    UserRepository userRepository = UserRepository.getInstance();

    public void run() {
        inputValue();
    }

    private void inputValue() {
        Input input = new Input();
        Output output = new Output();
        while (true) {
            try {
                String username = output.printInputUsernameBar(input);
                int ladderMaxHigh = output.printLadderMaxHighBar(input);
                init(username, ladderMaxHigh);
                break;
            } catch (WrongInputException e) {
                System.out.println(e.getMessage());
            }
        }
        input.close();
    }

    public void init(String username, int ladderMaxHigh) {
        createLadder(getUserCount(username), ladderMaxHigh);
        createUser(username);
    }

    private int getUserCount(String username) {
        return (int) Stream.of(username.split(",")).count();
    }

    private void createLadder(int userCount, int ladderHigh) {
        Ladder ladder = new Ladder(userCount, ladderHigh);
    }

    public void createUser(String username) {
        Stream.of(username.split(","))
                .forEach(s -> {
                    User user = new User(s);
                    userRepository.save(user);
                });
    }
}
