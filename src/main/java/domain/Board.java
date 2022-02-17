package domain;

import Util.Validation;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final String VERTICAL = "|";
    private static final String EMPTY_PART = "    ";

    private final int players;
    private final int height;
    private final List<List<String>> frame;
    private final Line line;

    public Board(int players, int height) {
        this.players = Validation.checkPlayers(players);
        this.height = Validation.checkHeight(height);
        frame = new ArrayList<>();
        line = new Line();
    }

    public int countPlayers() {
        return players;
    }

    public int getLadderHeight() {
        return height;
    }

    public void generateFrame() {
        for (int row = 0; row < height ; row++) {
            frame.add(draw(row));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        frame.forEach(floor -> floorToString(stringBuilder,floor));
        return stringBuilder.toString();
    }

    private List<String> draw(int row) {
        List<String> floor = new ArrayList<>();
        for (int col = 0; col < players*2-1 ; col++) {
            floor.add(drawLine(floor,col));
        }
        return floor;
    }

    private String drawLine(List<String> floor, int col) {
        if(col % 2 == 0) {
            return VERTICAL;
        }
        return line.generateRandomLine(floor,col);
    }

    private void floorToString(StringBuilder stringBuilder,List<String> floor) {
        stringBuilder.append(EMPTY_PART);
        for (String s : floor) {
            stringBuilder.append(formatFrame(s));
        }
        stringBuilder.append('\n');
    }

    private String formatFrame(String part) {
        if(part.equals(VERTICAL)) {
            return part;
        }
        return String.format("%5s",part);
    }


}

