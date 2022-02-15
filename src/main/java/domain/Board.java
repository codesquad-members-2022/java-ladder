package domain;

import Util.Valid;

import java.util.Arrays;

import static Util.Valid.checkPlayers;

public class Board {

    private static final String VERTICAL = "|";
    private final int players;
    private final int height;
    private final String[][] frame;
    private final Line line;

//    public Board(int players, int height) {
//        Valid.checkPlayers(players);
//        Valid.checkHegiht(height);
//        frame = new String[height][(players*2)-1];
//        line = new Line();
//    }

    public Board(int players, int height) {
        this.players = Valid.checkPlayersReturn(players);
        this.height = Valid.checkHeightReturn(height);
        frame = new String[this.height][(this.players*2)-1];
        line = new Line();
    }

    public int countPlayers() {
        return players;
    }

    public int getLadderHeight() {
        return height;
    }

    public void generateFrame() {
        for (int row = 0; row < frame.length ; row++) {
            draw(row);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String[] strings : frame) {
            stringBuilder.append(Arrays.toString(strings).replaceAll("\\[|\\]|,","")).append('\n');
        }
        return stringBuilder.toString();
    }

    private void draw(int row) {
        for (int col = 0; col < frame[row].length ; col++) {
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

