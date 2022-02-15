package app.jinan159.ladder;

import app.jinan159.ladder.meta.Elements;

import java.util.Scanner;

public class LadderGame {

    private final Elements[][] gameMap;

    public LadderGame() {
        Scanner sc = new Scanner(System.in);
        int participantCount = readParticipantCount(sc);
        int height = readHeight(sc);
        this.gameMap = setGameMapSize(participantCount * 2 - 1, height);

        prepareGameMap(this.gameMap);
    }

    private int readParticipantCount(Scanner sc) {
        try {
            System.out.println("참여할 사람은 몇 명 인가요?");
            return sc.nextInt();
        } catch (Exception e) {
            return readParticipantCount(sc);
        }
    }

    private int readHeight(Scanner sc) {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return sc.nextInt();
        } catch (Exception e) {
            return readHeight(sc);
        }
    }

    private Elements[][] setGameMapSize(int width, int height) {
        return new Elements[height][width];
    }

    private void prepareGameMap(Elements[][] gameMap) {
        for (int h = 0; h < gameMap.length; h++) {
            prepareRow(gameMap, h);
        }
    }

    private void prepareRow(Elements[][] gameMap, int h) {
        for (int w = 0; w < gameMap[0].length; w++) {
            prepareColumn(w, h);
        }
    }

    private void prepareColumn(int w, int h) {
        if (w % 2 == 0) setValueOnGameMap(w, h, Elements.V_LINE);
        if (w % 2 == 1) setHorizontalValueOnGameMap(w, h);
    }

    private void setValueOnGameMap(int width, int height, Elements elements) {
        gameMap[height][width] = elements;
    }
    private void setHorizontalValueOnGameMap(int width, int height) {
        if (isEmptyPosition(width, height)) {
            setValueOnGameMap(width, height, Elements.EMPTY);
            return;
        }

        setValueOnGameMap(width, height, Elements.H_LINE);
    }

    // 빈 공간이 들어올 자리인지, 아닌지를 반환하는 가상의 알고리즘
    private boolean isEmptyPosition(int width, int height) {
        return ((width * height) + (width + height)) % 3 == 0;
    }

    // public method
    public void startGame() {
        for(Elements[] row : gameMap) {
            printRow(row);
            System.out.println();
        }
    }

    private void printRow(Elements[] row) {
        for(Elements col : row) {
            System.out.print(col.getMark());
        }
    }
}