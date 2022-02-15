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

        prepareGameMap();
    }

    private int readParticipantCount(Scanner sc) {
        int count;

        try {
            System.out.println("참여할 사람은 몇 명 인가요?");
            count = sc.nextInt();
        } catch (Exception e) {
            return readParticipantCount(sc);
        }

        return count;
    }

    private int readHeight(Scanner sc) {
        int height;

        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            height = sc.nextInt();
        } catch (Exception e) {
            return readHeight(sc);
        }

        return height;
    }

    private Elements[][] setGameMapSize(int width, int height) {
        return new Elements[height][width];
    }

    private void prepareGameMap() {
        for (int h = 0; h < gameMap.length; h++) {
            for (int w = 0; w < gameMap[0].length; w++) {
                if (w % 2 == 0) setValueOnGameMap(w, h, Elements.V_LINE);
                if (w % 2 == 1) setHorizontalValueOnGameMap(w, h);
            }
        }
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

    private boolean isEmptyPosition(int width, int height) {
        return ((width * height) + (width + height)) % 3 == 0;
    }

    // public method
    public void startGame() {
        for(Elements[] row : gameMap) {
            for(Elements col : row) {
                System.out.print(col.getMark());
            }
            System.out.println();
        }
    }

}
