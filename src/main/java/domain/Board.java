package domain;

import java.util.Arrays;

import static Util.Valid.checkPlayers;

public class Board {

    private static final String VERTICAL = "|";
    private static final String BLANK = " ";

    private final String[][] frame;
    private final Line line;

    public Board(int players, int height) {
        checkPlayers(players);
        frame = new String[(players*2)-1][height];
        line = new Line();
    }

    public int countPlayers() {
        return frame.length/2+1;
    }

    public int getLadderHeight() {
        return frame[0].length;
    }

    public void generateFrame() {
        for (int row = 0; row < frame.length ; row++) {
            draw(row);
        }
    }


    private void draw(int row) {
        for (int col = 0; col < getLadderHeight() ; col++) {
            frame[row][col] = drawLine(col);
        }
    }

    private String drawLine(int col) {
        if(col % 2 == 0) {
            return VERTICAL;
        }
        return line.generateRandomLine();
    }
}

