package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private int heightOfLadder;
    private List<String> players;
    private List<String> results;
    private List<Line> lineLadder;

    public Ladder(List<String> players, List<String> results, int height) {
        this.players = players;
        this.results = results;
        this.heightOfLadder = height;
        this.init();
    }

    private void init() {
        this.lineLadder = make();
    }

    private List<Line> make() {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < heightOfLadder; i++) {
            ladder.add(new Line(players.size()));
        }
        return ladder;
    }
    public List<Line> getLadderInfo() {
        // deep copy
        return new ArrayList<>(lineLadder);
    }

    public List<String> getPlayersInfo() {
        // deep copy
        return new ArrayList<>(players);
    }

    public List<String> getResultsInfo() {
        // deep copy
        return new ArrayList<>(results);
    }
}

