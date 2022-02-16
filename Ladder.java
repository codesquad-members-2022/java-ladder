import java.util.List;
import java.util.Random;

public class Ladder {
    private final int memberCount;
    private final int height;
    private String[][] ladder;


    Random random = new Random();
    StringBuilder sb = new StringBuilder();

    public Ladder(int memberCount, int height) {
        ladder = new String[height][(memberCount * 2) - 1];
        this.height = height;
        this.memberCount = memberCount;
        this.ladder = createLadder();
    }

    private String[][] createLadder() {
        ladder = new String[height][(memberCount * 2) - 1];
        for (int row = 0; row < height; row++) {
            ladderRowData(row);
        }
        return ladder;
    }

    private void ladderRowData(int row) {
        for (int col = 0; col < ladder[row].length; col++) {
            rowElements(row, col);
        }
    }

    private void rowElements(int row, int col) {
        if (col % 2 == 0) {
            ladder[row][col] = "|";
        }
        if (col % 2 == 1) {
            ladder[row][col] = randomLine(random.nextBoolean());
            duplicateCheck(row, col);
        }
    }

    private void duplicateCheck(int row, int col) {
        if (col >= 2 && ladder[row][col - 2].equals("----")) {
            ladder[row][col] = "    ";
        }
    }


    private String randomLine(boolean trueCheck) {
        if (trueCheck) {
            return "----";
        }
        return "    ";
    }

    public String toString() {
        for (int height = 0; height < this.height; height++) {
            addRowData(sb, height);
            sb.append("\n");
        }
        return sb.toString();
    }

    private void addRowData(StringBuilder sb, int height) {
        for (int width = 0; width < ladder[height].length; width++) {
            sb.append(ladder[height][width]);
        }
    }
}
