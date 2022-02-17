package game;

import java.util.ArrayList;
import java.util.List;

public class GameRepository implements MemoryRepository{

    private static GameRepository instance;
    private GameRepository() {}

    public static GameRepository getInstance() {
        if (instance == null) {
            instance = new GameRepository();
        }
        return instance;
    }

    private static List<GameInfo> store = new ArrayList<>();
    @Override
    public void save(GameInfo gameInfo) {
        store.add(gameInfo);
    }

    @Override
    public int findPlayerNumber() {
        return store.get(0).getPlayerNum();
    }

    @Override
    public int findHeight() {
        return store.get(0).getHeight();
    }

    @Override
    public List<String> findPlayerNames() {
        return store.get(0).getPlayerNames();
    }


}
