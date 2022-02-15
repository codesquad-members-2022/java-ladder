import java.util.Random;

public class Ladder {

    private int playerCount;
    private int ladderMaxHeight;
    private int[][] lines;
    private static Random rnd = new Random();

    private Ladder() {
    }

    public static Ladder create(int playerCount, int ladderMaxHeight) {
        Ladder ladder = new Ladder();
        ladder.playerCount = playerCount;
        ladder.ladderMaxHeight = ladderMaxHeight;
        ladder.lines = new int[ladderMaxHeight][playerCount];
        return ladder;
    }

    public int[][] getLines() {
        return lines;
    }

    public void drawRandomLines() {
        int row = ladderMaxHeight;
        int col = playerCount;

        for (int row_i = 0; row_i < row; row_i++) {
            for (int col_i = 0; col_i < col - 1; col_i++) {
                if (isRandomDraw())
                    drawLine(row_i, col_i);
            }
        }
    }

    private boolean isRandomDraw() {
        return rnd.nextBoolean();
    }

    public void drawLine(int row, int col) {
        lines[row][col] = 1;
        lines[row][col + 1] = 1;
    }

}
