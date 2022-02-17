package src.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private static final String RAIL = "|";
    private static final String STEP = "-";
    private static final String BLANK = " ";
    private static final String NEW_LINE = "\n";
    private static final Random RANDOM = new Random();
    private String[][] ladder;
    private List<Player> players = new ArrayList<>();

    public Ladder(List<String> playerNames, int ladderHeight) {
        init(playerNames, ladderHeight);
        this.ladder = new String[ladderHeight][players.size() * 2 - 1];
        createLadder(players.size(), ladderHeight);
    }

    private void init(List<String> playerNames, int ladderHeight) {
        setPlayers(playerNames);
    }

    private void setPlayers(List<String> playerNames) {
        for (int i = 0; i < players.size(); i++) {
            addPlayer(playerNames.get(i), i);
        }
    }

    private void addPlayer(String name, int i) {
        if (name.length() > 5) {
            players.add(new Player(name.substring(0, 3) + "..", i));
            return;
        }
        players.add(new Player(name, i));

    }

    private void createLadder(int peopleCount, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            insertSingleLine(i);
        }
    }

    private void insertSingleLine(int currentHeight) {
        for (int i = 0; i < ladder[currentHeight].length; i++) {
            insertLadderBar(currentHeight, i);
        }
    }

    private void insertLadderBar(int currentHeight, int horizontalIndex) {
        if (horizontalIndex % 2 == 0) {
            ladder[currentHeight][horizontalIndex] = RAIL;
            return;
        }
        if (RANDOM.nextBoolean()) {
            ladder[currentHeight][horizontalIndex] = STEP;
            return;
        }
        ladder[currentHeight][horizontalIndex] = BLANK;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ladder.length; i++) {
            appendSingleLine(i, stringBuilder);
        }
        return stringBuilder.toString();
    }

    private void appendSingleLine(int currentHeight, StringBuilder stringBuilder) {
        for (int i = 0; i < ladder[currentHeight].length; i++) {
            stringBuilder.append(ladder[currentHeight][i]);
        }
        stringBuilder.append(NEW_LINE);
    }


}

