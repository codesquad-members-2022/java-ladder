package app.jinan159.ladder.meta.gamemap;

import app.jinan159.ladder.meta.LadderElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameMap {

    private final static String ALERT_WRONG_POINT_ACCESS = "잘못된 좌표로 접근하셨습니다.";

    private final List<GameMapRow> gameMap;
    private final int width;
    private final int height;

    public GameMap(int participantCount, int height) {
        this.width = participantCount * 2;
        this.height = height;
        gameMap = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            gameMap.add(new GameMapRow(width));
        }

        prepareGameMap(this);
    }

    public LadderElement get(int x, int y) {
        return gameMap.get(y)
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

    public String gameMapToString() {
        StringBuilder sb = new StringBuilder();

        for (GameMapRow row : this.gameMap) {
            sb.append(rowToString(row));
            sb.append('\n');
        }

        return sb.toString();
    }

    private String rowToString(GameMapRow row) {
        StringBuilder sb = new StringBuilder();
        for (GameMapColumn col : row) {
            sb.append(col.getColumnValue());
        }

        return sb.toString();
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

        if (isHorizontalLine.nextBoolean()) {
            return LadderElement.H_LINE;
        }

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
        gameMap.get(y).addColumn(x, new GameMapColumn(value));
    }

}
