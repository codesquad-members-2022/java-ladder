package application.domain;

import application.domain.ladder.Ladder;
import application.domain.player.Player;
import application.domain.player.Players;
import application.domain.result.Result;
import application.domain.result.Results;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static application.util.InputUtils.*;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Results results;
    private final Map<String, Result> resultMap;

    public LadderGame(Ladder ladder, Players players, Results results) {
        this.ladder = ladder;
        this.players = players;
        this.results = results;
        this.resultMap = new HashMap<>();
    }

    public void start() {
        ladder.createLadder();
        List<Player> playerList = players.getPlayers();
        List<Result> resultList = results.getResults();
        int num = playerList.size();
        for (int seq = 0; seq < num; ++seq) {
            resultMap.put(playerList.get(seq).getName(), resultList.get(ladder.go(0, seq)));
        }
    }

    public String getResult(String playerName) {
        StringBuilder sb = new StringBuilder();
        Result result = resultMap.get(playerName);
        sb.append(result != null ? result.output() : "");
        if (sb.length() == 0 && playerName.equals(ALL_CMD)) {
            sb.append(players.getPlayers().stream()
                    .map(this::resultString)
                    .collect(Collectors.joining()));
        }
        return sb.toString();
    }
    private String resultString(Player player) {
        String playerName = player.getName();
        return String.format("%s: %s\n", playerName, resultMap.get(playerName).output());
    }

    public String screen() {
        return players.output() + ladder.output() + results.output();
    }

    @Override
    public String toString() {
        return "LadderGame{" +
                "ladder=" + ladder +
                ", players=" + players +
                '}';
    }
}
