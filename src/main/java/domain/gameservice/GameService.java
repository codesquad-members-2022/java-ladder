package domain.gameservice;

import domain.ladder.Ladder;
import domain.ladder.LadderCreator;
import domain.ladder.Line;
import domain.item.Item;
import domain.item.ItemCreator;
import domain.user.User;
import domain.user.UserCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameService {
    private Map<String, User> users;
    private Map<Integer, Item> items;
    private Ladder ladder;

    public GameService( int lineHeight, String[] users,String[] items) {

        this.users = UserCreator.createUserMap(users);
        this.items = ItemCreator.createResultMap(items);
        this.ladder = LadderCreator.createLadder(lineHeight, calculateLadderWidth());
    }

    public Item getSinglePlayerResult(String username) {
        int userPoint = users.get(username).getPoint();

        for (int i = 0; i < ladder.getLadderSize(); i++) {
            userPoint += ladder.move(i, userPoint);
        }
        return items.get(userPoint);
    }

    public List<Line> getLadder() {
        return ladder.getLadders();
    }

    private int calculateLadderWidth() {
        return users.size() * 2 - 1;
    }

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public List<Item> getItems() {
        return new ArrayList<>(items.values());
    }
}
