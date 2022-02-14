package main;

import java.util.Random;

public class LadderGame {

    private final int numPerson;
    private final int numLadder;

    private int height;
    private int width;
    private LadderChar[][] map;

    public LadderGame(int numPerson, int numLadder) {
        this.numPerson = numPerson;
        this.numLadder = numLadder;
    }

    public void createMap() {
        this.width = getWidth();
        this.height = getHeight();
        this.map = new LadderChar[height][width];

        addLadderChars();
    }

    public LadderChar[][] getMap() {
        return this.map;
    }

    private int getWidth() {
        return 2 * this.numPerson - 1;
    }

    private int getHeight() {
        return this.numLadder;
    }

    private void addLadderChars() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                addLadderChar(i, j);
            }
        }
    }

    private void addLadderChar(int i, int j) {
        if (j % 2 == 0) {
            this.map[i][j] = LadderChar.VERTICAL;
        } else if (RandomUtil.nextBoolean()) {
            this.map[i][j] = LadderChar.SPACE;
        } else {
            this.map[i][j] = LadderChar.HORIZONTAL;
        }
    }

}
