package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final String[] results;
    private final Map<String, String> resultMap = new HashMap<>();

    public LadderGame(Players players, int height, String[] results) {
        this.players = players;
        this.ladder = new Ladder(players.countOfPlayers(), height);
        this.results = results;
        saveResultMap();
    }

    public String Game2Text() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(players.playersName2Text()).append(System.lineSeparator());
        stringBuilder.append(ladder.toString());
        Arrays.stream(results).forEach(result -> stringBuilder.append(String.format("%6s",result)));
        return stringBuilder.append(System.lineSeparator()).toString();
    }

    private void saveResultMap() {
        for (int i = 0; i < results.length ; i++) {
            String name = players.findName(i);
            resultMap.put(name,results[i]);
        }
    }




}
