package app.jinan159.ladder.domain.gamemap;

import app.jinan159.ladder.domain.LadderElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GameMap implements Iterable<GameMapRow> {

    private final static String ALERT_WRONG_POINT_ACCESS = "잘못된 좌표로 접근하셨습니다.";

    private final List<GameMapRow> gameMapRows;
    private final int width;
    private final int height;

    public GameMap(int participantCount, int height) {
        this.width = participantCount * 2;
        this.height = height;
        gameMapRows = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            gameMapRows.add(new GameMapRow(width));
        }

        prepareGameMap(this);
    }

    public LadderElement get(int x, int y) {
        return gameMapRows.get(y)
                .getColumn(x)
                .orElseThrow(()->new IllegalStateException(ALERT_WRONG_POINT_ACCESS))
                .getElement();
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
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
        // 첫 번째 column은 lpad를 입력함
        if (x == 0) return LadderElement.L_PAD;

        // 짝수 번째 column은 세로줄을 입력함
        if (x % 2 == 1) return LadderElement.V_LINE;

        return getRandomLadderElement(x, y);
    }

    // 랜덤으로 사다리 요소를 반환
    private LadderElement getRandomLadderElement(int x, int y) {
        if (isEmptyPosition(x, y)) return LadderElement.EMPTY;

        Random isHorizontalLine = new Random();
        if (isHorizontalLine.nextBoolean()) return LadderElement.H_LINE;

        return LadderElement.EMPTY;
    }

    // 현재 포지션의 왼쪽에 가로선이 있어서 빈 공간이 들어가야 하는지 여부
    private boolean isEmptyPosition(int x, int y) {
        return x > 3 && isLeftHorizontalLine(x, y);
    }

    private boolean isLeftHorizontalLine(int x, int y) {
        return get(x - 2, y).equals(LadderElement.H_LINE);
    }

    private void set(int x, int y, LadderElement value) {
        gameMapRows.get(y).addColumn(x, new GameMapColumn(value));
    }

    @Override
    public Iterator<GameMapRow> iterator() {
        return new GameMapIterator();
    }

    private class GameMapIterator implements Iterator<GameMapRow> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < gameMapRows.size();
        }

        @Override
        public GameMapRow next() {
            GameMapRow row = gameMapRows.get(cursor);
            cursor++;

            return row;
        }
    }
}
