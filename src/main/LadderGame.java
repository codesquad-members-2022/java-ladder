package main;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static final String BLANK = "     ";
    private static final String RUNG = "-----";
    private static final String RAIL = "|";
    private final int playerNum;
    private final int height;
    private final int width;
    private final List<List<String>> ladderArr = new ArrayList<>();

    private boolean previous = false;

    public LadderGame(int playerNum, int height, String[] playerNames) {
        this.playerNum = playerNum;
        this.height = height;
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
        ladderArr.stream().forEach(a -> {
            a.stream().forEach(s -> System.out.print(s));
            System.out.println("");
        });
    }
}
