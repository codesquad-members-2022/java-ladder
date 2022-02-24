package application.domain;

import application.domain.ladder.Ladder;
import application.domain.player.Player;
import application.domain.player.Players;
import application.domain.result.Result;
import application.domain.result.Results;

import java.util.HashMap;
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

    public void setGame() {
        ladder.createLadder();
        int num = players.getTotalNum();
        for (int idx = 0; idx < num; ++idx) {
            resultMap.put(players.getPlayer(idx).getName(), results.getResult(ladder.go(0, idx)));
        }
    }

    public String getResult(String playerName) {
        StringBuilder sb = new StringBuilder();
        Result result = resultMap.get(playerName);
        sb.append(result != null ? result.output() : "");
        if (playerName.equals(ALL_CMD)) {
            sb.append(players.resultOutput(resultMap));
        }
        return sb.toString();
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
