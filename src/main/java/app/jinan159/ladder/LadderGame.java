package app.jinan159.ladder;

import app.jinan159.ladder.meta.LadderElement;
import app.jinan159.ladder.meta.GameMap;
import app.jinan159.ladder.stretegy.DefaultGameMapStretegy;
import app.jinan159.ladder.stretegy.LadderGameMapStretegy;

import java.util.Scanner;

public class LadderGame {

    private final GameMap gameMap;
    private final LadderGameMapStretegy stretegy;

    public LadderGame() {
        this(new DefaultGameMapStretegy());
    }

    public LadderGame(LadderGameMapStretegy stretegy) {
        try (Scanner sc = new Scanner(System.in)) {
            int participantCount = readParticipantCount(sc);
            int height = readHeight(sc);
            this.gameMap = new GameMap(participantCount, height);
        }

        this.stretegy = stretegy;
        prepareGameMap(this.gameMap);
    }

    // ------- initialize private method ---------
    private int readParticipantCount(Scanner sc) {
        try {
            System.out.println("참여할 사람은 몇 명 인가요?(1명 이상)");
            int count = sc.nextInt();
            validateParticipantCount(count);
            return count;
        } catch (Exception e) {
            return readParticipantCount(sc);
        }
    }

    private void validateParticipantCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private int readHeight(Scanner sc) {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?(1개 이상)");
            int height = sc.nextInt();
            validateHeight(height);
            return height;
        } catch (Exception e) {
            return readHeight(sc);
        }
    }

    private void validateHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void prepareGameMap(GameMap gameMap) {
        for (int y = 0; y < gameMap.getHeight(); y++) {
            prepareRow(gameMap, y);
        }
    }

    private void prepareRow(GameMap gameMap, int y) {
        for (int x = 0; x < gameMap.getWidth(); x++) {
            LadderElement element = stretegy.getLadderElementOnPotision(x, y);
            gameMap.set(x, y, element);
        }
    }

    // ------- public method ---------
    public void startGame() {
        printGameMap();
    }

    // ------- private method ---------
    private void printGameMap() {
        System.out.println(gameMap.gameMapToString());
    }
}