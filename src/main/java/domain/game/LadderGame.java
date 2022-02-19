package domain.game;

import domain.ladder.Ladder;
import domain.user.User;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final List<User> users;
    private final Ladder ladder;

    LadderGame(List<User> users, Ladder ladder) {
        this.users = users;
        this.ladder = ladder;
    }

    Ladder getLadder() {
        return this.ladder;
    }

    List<String> getUserNames() {
        return users.stream()
                    .map(User::getName)
                    .collect(Collectors.toList());
    }
}
