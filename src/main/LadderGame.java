package main;

import java.util.List;
import main.util.RandomUtil;

public class LadderGame {

    private final List<String> names;
    private final int numLadder;

    private int height;
    private int width;
    private LadderChar[][] map;

    public LadderGame(List<String> names, int numLadder) {
        this.names = names;
        this.numLadder = numLadder;
    }

    public void createMap() {
        this.width = getWidth();
        this.height = getHeight();
        this.map = new LadderChar[height][width];

        changePlane();
    }

    public LadderChar[][] getMap() {
        return this.map;
    }

    private int getWidth() {
        return 2 * this.names.size() - 1;
    }

    private int getHeight() {
        return this.numLadder;
    }

    private void changePlane() {
        for (int row = 0; row < height; row++) {
            changeLine(row);
        }
    }

    private void changeLine(int row) {
        for (int col = 0; col < width; col++) {
            changeChar(row, col);
        }
    }

    private void changeChar(int row, int col) {
        if (col % 2 == 0) {
            this.map[row][col] = LadderChar.VERTICAL;
        }
        if (col % 2 != 0) {
            changeRandomChar(row, col);
        }
    }

    private void changeRandomChar(int row, int col) {
        boolean rand = RandomUtil.nextBoolean();

        if (rand) {
            this.map[row][col] = LadderChar.SPACE;
        }
        if (!rand) {
            this.map[row][col] = LadderChar.HORIZONTAL;
        }
    }

}
