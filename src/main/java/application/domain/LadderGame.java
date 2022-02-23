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

import static application.util.InputUtils.ALL_CMD;

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

    private String resultString(Player player) {
        return String.format("%s: %s\n", player.getName(), resultMap.get(player.getName()));
    }

    public String screen() {
        return players.output() + ladder.output();
    }

    @Override
    public String toString() {
        return "LadderGame{" +
                "ladder=" + ladder +
                ", players=" + players +
                '}';
    }
}
