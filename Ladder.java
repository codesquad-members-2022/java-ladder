
import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private final int memberCount;
    private final int height;
    ArrayList<ArrayList<String>> ladder;

    Random random = new Random();
    StringBuilder sb = new StringBuilder();

    public Ladder(int memberCount, int height) {
        this.height = height;
        this.memberCount = memberCount;
        this.ladder = createLadder();
    }

    private ArrayList<ArrayList<String>> createLadder() {
        ArrayList<ArrayList<String>> ladder = new ArrayList<>();
        for (int row = 0; row < height; row++) {
            ArrayList<String> ladderRow = new ArrayList<>();
            addLadderRow(ladderRow);
            ladder.add(ladderRow);
        }
        return ladder;
    }

    private void addLadderRow(ArrayList<String> ladderRow) {
        for (int column = 0; column < memberCount * 2 - 1; column++) {
            addRowElements(ladderRow, column);
        }
    }

    private void addRowElements(ArrayList<String> ladderRow, int column) {
        if (column % 2 == 0) {
            ladderRow.add("|");
        }
        if (column % 2 == 1) {
            ladderRow.add(addRandomLine(random.nextBoolean()));
            lineDuplicateCheck(ladderRow, column);
        }
    }

    private void lineDuplicateCheck(ArrayList<String> ladderRow, int column) {
        if (column >= 2 && ladderRow.get(column - 2).equals("-----")) {
            ladderRow.set(column, "     ");
        }

    }

    private String addRandomLine(boolean trueCheck) {
        if (trueCheck) {
            return "-----";
        }
        return "     ";
    }


    public String toString() {
        for (int row = 0; row < height; row++) {
            addRowData(sb, row);
            sb.append("\n");
        }
        return sb.toString();
    }

    private void addRowData(StringBuilder sb, int row) {
        for (int column = 0; column < memberCount * 2 - 1; column++) {
            sb.append(ladder.get(row).get(column));
        }
    }
}
