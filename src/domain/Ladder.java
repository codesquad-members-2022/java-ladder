package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int WIDTH = 5;
    private int numberOfPeople;
    private int heightOfLadder;
    private List<String> players;
    private List<Line> lineLadder;

    public Ladder(List<String> players, int m) {
        this.players = players;
        this.numberOfPeople = players.size();
        this.heightOfLadder = m;
        this.init();
    }

    private void init() {
        this.lineLadder = make();
    }

    private List<Line> make() {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < heightOfLadder; i++) {
            ladder.add(new Line(numberOfPeople));
        }
        return ladder;
    }

    public String Info() {
        StringBuilder sb = new StringBuilder();
        sb.append(putPlayers());
        for (int i = 0; i < heightOfLadder; i++) {
            sb.append(rowOfLadderInfo(i));
        }

        return sb.toString();
    }

    private String rowOfLadderInfo(int index) {
        StringBuilder sb = new StringBuilder();
        String expandedRow;
        sb.append("  |");
        for (int i = 0; i < numberOfPeople - 1; i++) {
            expandedRow = expandRowWidth(lineLadder.get(index).get(i));
            sb.append(expandedRow);
            sb.append("|");
        }
        sb.append("\n");
        return sb.toString();
    }

    private String expandRowWidth(boolean element) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < WIDTH; i++) {
            sb.append(transValue(element));
        }
        return sb.toString();
    }

    private char transValue(boolean element) {
        if (element) {
            return '-';
        }
        return ' ';
    }

    private String putPlayers() {
        StringBuilder sb = new StringBuilder();
        for (String player : players) {
            sb.append(Formatter.checkAndPadding(player, WIDTH));
            sb.append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }

}

