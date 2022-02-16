import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class Ladder {
    private final int WIDTH = 5;
    private final int CENTER_OF_LETTERS = WIDTH/2;
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
            rowOfLadder.add(setRandomValue());
        }
        return rowOfLadder;
    }

    private char setRandomValue() {
        Random rand = new Random();
        int temp = rand.nextInt(2); // 0, 1 중 하나의 값
        if (temp == 0) {
            return ' ';
        }
        return '-';
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
        for (String player : players){
            sb.append(checkPlayer(player));
            sb.append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }

    private String checkPlayer(String player) {
    if (player.length() >= WIDTH){
        return player.substring(0, 5);
    }
        return addPadding(player);
    }

    private String addPadding(String player) {
        StringBuilder sb = new StringBuilder();
        if (player.length() <= CENTER_OF_LETTERS){
            sb.append(addLeftPadding(player));
        }
        sb.append(player);
        sb.append(addRightPadding(sb.toString()));

        return sb.toString();
    }

    private String addLeftPadding(String player){
        if (player.length() < CENTER_OF_LETTERS){
            return "  ";
        }
        return " ";
    }

    private String addRightPadding(String player){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < WIDTH - player.length(); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }


}

