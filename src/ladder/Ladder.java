package src.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private List<LadderRow> ladderRows;
    private List<Player> players = new ArrayList<>();

    public Ladder(List<String> playerNames, int ladderHeight) {
        init(playerNames, ladderHeight);
    }

    private void init(List<String> playerNames, int ladderHeight) {
        setPlayers(playerNames);
        createLadder(players.size(), ladderHeight);
    }

    private void setPlayers(List<String> playerNames) {
        for (int i = 0; i < players.size(); i++) {
            players.add(new Player(playerNames.get(i), i));
        }
    }

    private void createLadder(int playerCount, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            ladderRows.add(new LadderRow(playerCount));
        }
    }

//    private void insertSingleLine(int currentHeight) {
//        for (int i = 0; i < ladder[currentHeight].length; i++) {
//            insertLadderBar(currentHeight, i);
//        }
//    }
//
//    private void insertLadderBar(int currentHeight, int horizontalIndex) {
//        if (horizontalIndex % 2 == 0) {
//            ladder[currentHeight][horizontalIndex] = RAIL;
//            return;
//        }
//        if (RANDOM.nextBoolean()) {
//            ladder[currentHeight][horizontalIndex] = STEP;
//            return;
//        }
//        ladder[currentHeight][horizontalIndex] = BLANK;
//    }

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

