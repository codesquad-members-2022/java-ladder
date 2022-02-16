package app.jinan159.ladder.meta;

import java.util.ArrayList;
import java.util.List;

public class GameMap {

    private final List<List<LadderElement>> gameMap;
    private final int width;
    private final int height;

    public GameMap(int participantCount, int height) {
        this.width = participantCount * 2;
        this.height = height;
        gameMap = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            gameMap.add(new ArrayList<>(width));
        }

        prepareGameMap(this);
    }

    public LadderElement get(int x, int y) {
        return gameMap.get(y).get(x);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String gameMapToString() {
        StringBuilder sb = new StringBuilder();

        for (List<LadderElement> row : this.gameMap) {
            sb.append(rowToString(row));
            sb.append('\n');
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

        // 가상의 알고리즘 상으로, empty
        if (isEmptyPosition(x, y)) return LadderElement.EMPTY;

        return LadderElement.H_LINE;
    }

    // 빈 공간이 들어올 자리인지, 아닌지를 반환하는 가상의 알고리즘
    private boolean isEmptyPosition(int x, int y) {
        return ((x * y) + (x + y)) % 3 == 0;
    }

    private String rowToString(List<LadderElement> row) {
        StringBuilder sb = new StringBuilder();
        for (LadderElement col : row) {
            sb.append(col.getMark());
        }

        return sb.toString();
    }

    private void set(int x, int y, LadderElement value) {
        gameMap.get(y).add(x, value);
    }

}
