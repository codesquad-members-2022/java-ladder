package main.laddergame;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static final String BLANK = "     ";
    private static final String RUNG = "-----";
    private static final String RAIL = "|";
    private static final String LEFT_MARGIN = "  ";
    private static final String DEFAULT_NAME = "men";

    private final int playerNum;
    private final int height;
    private final int width;
    private final List<List<String>> ladderArr = new ArrayList<>();
    private final String[] playerNames;

    private boolean previous = false;

    public LadderGame(int playerNum, int height, String[] playerNames) {
        this.playerNum = playerNum;
        this.height = height;
        this.playerNames = playerNames;
        width = playerNum * 2 - 1;
        createLadder();
    }

    private void createLadder() {
        for (int i = 0; i < height; i++) {
            ladderArr.add(generate(i));
        }
    }

    private ArrayList<String> generate(int h) {
        ArrayList<String> result = new ArrayList<>();
        for (int j = 0; j < width; j++) {
            result.add(randomlyAddRung(j));
        }
        return result;
    }

    private String randomlyAddRung(int j) {
        if (j % 2 == 0) {
            return RAIL;
        }
        return (Math.random() > 0.5 && !previous) ? addRung() : addBlank();
    }

    private String addRung() {
        previous = true;
        return RUNG;
    }

    private String addBlank() {
        previous = false;
        return BLANK;
    }

    public void printLadderGame() {
        // 사다리정보와 유저정보 출력
        printUserNames();
        for (List<String> strings : ladderArr) {
            printSingleUnit(strings);
        }
    }

    private void printSingleUnit(List<String> strings) {
        System.out.print(LEFT_MARGIN);
        strings.stream().forEach(System.out::print);
        System.out.println("");
    }

    private void printUserNames() {
        for (int i = 0; i < playerNames.length; i++) {
            printUserName(playerNames[i]);
        }

        for (int i = playerNames.length; i < playerNum; i++) {
            String playerName = DEFAULT_NAME + i;
            printUserName(playerName);
        }
        System.out.println("");
    }

    private void printUserName(String playerName) {
        System.out.printf("%5s ", playerName);
    }
}
