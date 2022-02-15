package app.jinan159.ladder;

import app.jinan159.ladder.meta.Elements;
import app.jinan159.ladder.meta.GameMap;

import java.util.Scanner;

public class LadderGame {

    private final GameMap gameMap;

    public LadderGame() {
        Scanner sc = new Scanner(System.in);
        int participantCount = readParticipantCount(sc);
        int height = readHeight(sc);
        this.gameMap = new GameMap(participantCount, height);

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

    private void prepareGameMap(GameMap gameMap) {
        for (int y = 0; y < gameMap.getHeight(); y++) {
            prepareRow(gameMap, y);
        }
    }

    private void prepareRow(GameMap gameMap, int y) {
        for (int x = 0; x < gameMap.getWidth(); x++) {
            prepareColumn(x, y);
        }
    }

    private void prepareColumn(int x, int y) {
        if (x % 2 == 0) gameMap.set(x, y, Elements.V_LINE);
        if (x % 2 == 1) setHorizontalValueOnGameMap(x, y);
    }

    private void setHorizontalValueOnGameMap(int x, int y) {
        if (isEmptyPosition(x, y)) {
            gameMap.set(x, y, Elements.EMPTY);
            return;
        }

        gameMap.set(x, y, Elements.H_LINE);
    }

    // 빈 공간이 들어올 자리인지, 아닌지를 반환하는 가상의 알고리즘
    private boolean isEmptyPosition(int x, int y) {
        return ((x * y) + (x + y)) % 3 == 0;
    }

    // public method
    public void startGame() {
        for (int h = 0; h < gameMap.getHeight(); h++) {
            printRow(gameMap, h);
        }
    }

    private void printRow(GameMap gameMap, int y) {
        for (int x = 0; x < gameMap.getWidth(); x++) {
            System.out.print(gameMap.get(x, y).getMark());
        }
        System.out.println();
    }
}