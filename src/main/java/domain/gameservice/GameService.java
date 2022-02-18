package domain.gameservice;

import domain.ladder.Ladder;
import domain.ladder.LadderCreator;
import domain.ladder.Line;
import domain.item.Item;
import domain.item.ItemCreator;
import domain.user.User;
import domain.user.UserCreator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameService {
    private Map<String, User> users;
    private Map<Integer, Item> items;
    private Ladder ladder;
    private Map<String, String> results;

    public GameService( int lineHeight, String[] users,String[] items) {

        this.users = UserCreator.createUserMap(users);
        this.items = ItemCreator.createResultMap(items);
        this.ladder = LadderCreator.createLadder(lineHeight, calculateLadderWidth());
        this.results = new HashMap<>();
    }

    public void playGame() {
        for (String user : users.keySet()) {
            results.putAll(playSinglePlayer(users.get(user)));
        }
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public List<Item> getItems() {
        return new ArrayList<>(items.values());
    }

    public List<Line> getLadder() {
        return ladder.getLadders();
    }

    public Map<String, String> getResults() {
        return results;
    }

    public String getSingleUserResult(String username) {
        return results.get(username);
    }

    private Map<String, String> playSinglePlayer(User user) {
        int userPoint = user.getPoint();

        for (int i = 0; i < ladder.getLadderSize(); i++) {
            userPoint += ladder.move(i, userPoint);
        }
        Item item = items.get(userPoint);
        return new HashMap<>(){{
            put(user.getName(), item.getName());}};
    }

    private int calculateLadderWidth() {
        return users.size() * 2 - 1;
    }


}
