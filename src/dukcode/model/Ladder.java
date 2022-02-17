package dukcode.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private int height;
    private int numPlayer;
    private int numSteps;
    private String[] namePlayers;
    private List<List<Boolean>> ladder;

    public Ladder() {}

    public String[] getNamePlayers() {
        String[] copyNamePlayers = new String[numPlayer];
        System.arraycopy(namePlayers, 0, copyNamePlayers, 0, numPlayer);
        return copyNamePlayers;
    }
    public int getNumPlayer() {
        return numPlayer;
    }
    public int getHeight() {
        return height;
    }

    public int getNumSteps() {
        return numPlayer - 1;
    }

    public Boolean[][] getLadder() {
        Boolean[][] copyLadder = new Boolean[height][numSteps];
        for (int line = 0; line < height; ++line) {
            copyLadder[line] = ladder.get(line).toArray(new Boolean[numSteps]);
        }

        return copyLadder;
    }

    public void init(String[] namePlayers, int height) {
        this.namePlayers = namePlayers;
        this.numPlayer = namePlayers.length;
        this.numSteps = namePlayers.length - 1;
        this.height = height;

        ladder = new ArrayList<>();
        for (int lineNum = 0; lineNum < height; ++lineNum) {
            initLine(lineNum);
        }
    }

    private void initLine(int lineNum) {
        Random rd = new Random();
        ArrayList<Boolean> line = new ArrayList<Boolean>();
        for (int step = 0; step < numSteps; ++step) {
            line.add(getStep(line, rd, step));
        }
        ladder.add(line);
    }

    private boolean getStep(ArrayList<Boolean> line, Random rd, int step) {
        if (step == 0) {
            return rd.nextBoolean();
        }

        // 왼쪽에 step 존재하면 false, 없으면 random
        return !line.get(step - 1) && rd.nextBoolean();
    }

}
