package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private static final String KEY_VALUE_DELIMITER = " : ";

    private final Players players;
    private final Ladder ladder;
    private final String[] results;
    private final Map<String, String> resultMap = new HashMap<>();

    public LadderGame(Players players, String[] results, int height) {
        this.players = players;
        this.ladder = new Ladder(players.countOfPlayers(), height);
        this.results = results;
        rideLadder();
        saveResultMap();
    }

    public String game2Text() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(players.playersName2Text()).append(System.lineSeparator());
        stringBuilder.append(ladder.toString());
        Arrays.stream(results).forEach(result -> stringBuilder.append(String.format("%6s", result)));
        return stringBuilder.append(System.lineSeparator()).toString();
    }

    public String findResult(String name) {
        if (players.containsPlayer(name)) {
            return name + KEY_VALUE_DELIMITER + resultMap.get(name);
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

    private void rideLadder() {
        players.rideLadder(ladder);
    }

    private void saveResultMap() {
        for (int i = 0; i < results.length; i++) {
            resultMap.put(players.findName(i), results[i]);
        }
    }


}
