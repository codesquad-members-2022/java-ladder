
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private static final String HORIZON = "-----";
    private static final String VERTICAL = "|";
    private  static final String BLANK = "     ";
    private final int memberCount;
    private final int height;
    List<List<String>> ladder;

    Random random = new Random();
    StringBuilder sb = new StringBuilder();

    public Ladder(int memberCount, int height) {
        this.height = height;
        this.memberCount = memberCount;
        this.ladder = createLadder();
    }

    private List<List<String>> createLadder() {
        List<List<String>> ladder = new ArrayList<>();
        for (int row = 0; row < height; row++) {
            List<String> ladderRow = new ArrayList<>();
            addLadderRow(ladderRow);
            ladder.add(ladderRow);
        }
        return ladder;
    }

    private void addLadderRow(List<String> ladderRow) {
        for (int column = 0; column < memberCount * 2 - 1; column++) {
            addRowElements(ladderRow, column);
        }
    }

    private void addRowElements(List<String> ladderRow, int column) {
        if (column % 2 == 0) {
            ladderRow.add(VERTICAL);
        }
        if (column % 2 == 1) {
            ladderRow.add(addRandomLine(random.nextBoolean()));
            lineDuplicateCheck(ladderRow, column);
        }
    }

    private void lineDuplicateCheck(List<String> ladderRow, int column) {
        if (column >= 2 && ladderRow.get(column - 2).equals(HORIZON)) {
            ladderRow.set(column, BLANK);
        }

    }

    private String addRandomLine(boolean trueCheck) {
        if (trueCheck) {
            return HORIZON;
        }
        return BLANK;
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
