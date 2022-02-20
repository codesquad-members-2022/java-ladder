package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final String[] results;
    private final Map<String, String> resultMap = new HashMap<>();

    public LadderGame(Players players, String[] results, int height) {
        this.players = players;
        this.ladder = new Ladder(players.countOfPlayers(), height);
        this.results = results;
    }

    public void start() {
        rideLadder();
        saveResultMap();
    }

    public String findResult(String name) {
        if (players.containsPlayer(name)) {
            return resultMap.get(name);
        }
        throw new IllegalArgumentException();
    }

    public String getAllResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : resultMap.keySet()) {
            stringBuilder.append(key).append(KEY_VALUE_DELIMITER).append(resultMap.get(key)).append('\n');
        }
        return stringBuilder.toString();
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }

    private void rideLadder() {
        players.rideLadder(ladder);
    }

    private void saveResultMap() {
        for (int i = 0; i < results.length; i++) {
            resultMap.put(players.findName(i), results[i]);
        }
    }


}
