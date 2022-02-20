package dukcode.ladder;

import dukcode.ladder.domain.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {

    private int height;
    private int numPlayers;
    private int numSteps;
    private String[] namePlayers;
    private String[] results;
    private List<Line> ladder;

    public Ladder() {}

    public String[] getNamePlayers() {
        String[] copyNamePlayers = new String[numPlayers];
        System.arraycopy(namePlayers, 0, copyNamePlayers, 0, numPlayers);
        return copyNamePlayers;
    }

    public String[] getResults() {
        String[] copyResults = new String[numPlayers];
        System.arraycopy(results, 0, copyResults, 0, numPlayers);
        return copyResults;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public int getHeight() {
        return height;
    }

    public int getNumSteps() {
        return numSteps;
    }

    public Boolean[][] getLadder() {
        Boolean[][] copyLadder = new Boolean[height][numSteps];
        for (int line = 0; line < height; ++line) {
            copyLadder[line] = ladder.get(line).getStepArray();
        }

        return copyLadder;
    }

    public void init(String[] namePlayers, String[] results, int height) {
        this.namePlayers = namePlayers;
        this.numPlayers = namePlayers.length;
        this.results = results;
        this.numSteps = namePlayers.length - 1;
        this.height = height;

        ladder = new ArrayList<>(height);
        for (int i = 0; i < height; ++i) {
            ladder.add(new Line(numSteps));
        }
    }

    public int getPlayerIdx(String namePlayer) {
        return Arrays.asList(namePlayers).indexOf(namePlayer);
    }

    public int getResultIdx(int playerIdx) {
        int result = playerIdx;
        for (int line = 0; line < height; ++line) {
            result = ladder.get(line).getNextPosition(result);
        }

        return result;
    }
}
