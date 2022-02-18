package domain.service;

import domain.Ladder;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private List<User> users;
    private Ladder ladder;

    public GameService(int ladderHeight, String[] user) {

        this.users = getUserList(user);
        this.ladder = new Ladder(ladderHeight, calculateLadderWidth());
    }

    public String getGameResult() {
        StringBuilder sb = new StringBuilder();

        users.forEach(user -> {
            sb.append(user.getName() + " ");
        });
        sb.append("\n");
        sb.append(ladder.toString());

        return sb.toString();
    }

    private List<User> getUserList(String[] users) {
        List<User> list = new ArrayList<>();
        for (String user : users) {
            list.add(User.createUser(user));
        }
        return list;
    }

    private int calculateLadderWidth() {
        return users.size() * 2 - 1;
    }
}
