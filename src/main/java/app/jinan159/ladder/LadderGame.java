package app.jinan159.ladder;

import app.jinan159.ladder.io.InputReader;
import app.jinan159.ladder.io.OutputWriter;
import app.jinan159.ladder.meta.GameMap;
import app.jinan159.ladder.meta.LadderElement;

import java.io.IOException;

public class LadderGame {

    private final GameMap gameMap;

    public LadderGame() throws IOException {
        try (InputReader reader = new InputReader()) {
            int participantCount = reader.readParticipantCount();
            int height = reader.readHeight();
            this.gameMap = new GameMap(participantCount, height);
        }

        prepareGameMap(this.gameMap);
    }

    private void prepareGameMap(GameMap gameMap) {
        for (int y = 0; y < gameMap.getHeight(); y++) {
            prepareRow(gameMap, y);
        }
    }

    private void prepareRow(GameMap gameMap, int y) {
        for (int x = 0; x < gameMap.getWidth(); x++) {
            LadderElement element = getLadderElementOnPotision(x, y);
            gameMap.set(x, y, element);
        }
    }

    private LadderElement getLadderElementOnPotision(int x, int y) {
        // 홀수 번째 column은 세로줄을 입력함
        if (x % 2 == 0) return LadderElement.V_LINE;

        // 가상의 알고리즘 상으로, empty
        if (isEmptyPosition(x, y)) return LadderElement.EMPTY;

        return LadderElement.H_LINE;
    }

    // 빈 공간이 들어올 자리인지, 아닌지를 반환하는 가상의 알고리즘
    private boolean isEmptyPosition(int x, int y) {
        return ((x * y) + (x + y)) % 3 == 0;
    }

    // ------- public method ---------
    public void startGame() throws IOException {
        try (OutputWriter writer = new OutputWriter()) {
            writer.write(gameMap.gameMapToString());
        }
    }
}
