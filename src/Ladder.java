import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Ladder {
    private final int WIDTH = 5;
    private final int CENTER_OF_LETTERS = (WIDTH / 2) + 1;
    private int numberOfPeople;
    private int heightOfLadder;
    private List<String> players;
    private List<List<Character>> charLadder;

    Ladder(List<String> players, int m) {
        this.players = players;
        this.numberOfPeople = players.size();
        this.heightOfLadder = m;
        this.init();
    }

    private void init() {
        this.charLadder = make();
    }

    private List<List<Character>> make() {
        List<List<Character>> ladder = new ArrayList<>();
        for (int i = 0; i < heightOfLadder; i++) {
            ladder.add(makeRow());
        }
        return ladder;
    }

    private List<Character> makeRow() {
        List<Character> rowOfLadder = new ArrayList<>();
        for (int i = 0; i < numberOfPeople - 1; i++) {
            rowOfLadder.add(setRandomValue(rowOfLadder, i));
        }
        return rowOfLadder;
    }

    private char setRandomValue(List<Character> rowOfLadder, int index) {
        Random rand = new Random();
        int temp = rand.nextInt(2); // 0, 1 중 하나의 값
        if (temp == 1 && !checkLineOverlap(rowOfLadder, index)) {
            return '-';
        }

        return ' ';
    }

    private boolean checkLineOverlap(List<Character> rowOfLadder, int index) {
        if (index != 0) {
            return isLine(rowOfLadder, index);
        }
        return false;
    }

    private boolean isLine(List<Character> rowOfLadder, int index) {
        char valueOfLine = rowOfLadder.get(index - 1);
        if (valueOfLine == '-'){
            return true;
        }
        return false;
    }

    public String Info() {
        StringBuilder sb = new StringBuilder();
        sb.append(putPlayers());
        for (int i = 0; i < heightOfLadder; i++) {
            sb.append(rowOfLadderInfo(i));
        }

        return sb.toString();
    }

    private String rowOfLadderInfo(int index) {
        StringBuilder sb = new StringBuilder();
        String expandedRow;
        sb.append("  |");
        for (int i = 0; i < numberOfPeople - 1; i++) {
            expandedRow = expandRowWidth(charLadder.get(index).get(i));
            sb.append(expandedRow);
            sb.append("|");
        }
        sb.append("\n");
        return sb.toString();
    }

    private String expandRowWidth(char element) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < WIDTH; i++) {
            sb.append(element);
        }
        return sb.toString();
    }

    private String putPlayers() {
        StringBuilder sb = new StringBuilder();
        for (String player : players) {
            sb.append(Formatter.check(player, WIDTH));
            sb.append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }

}

