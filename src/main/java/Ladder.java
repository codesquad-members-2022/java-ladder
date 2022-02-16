import java.util.Random;

public class Ladder {
    private int playerCount;
    private int ladderMaxHeight;
    private int[][] lines;
    private static final Random rnd = new Random();

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
        for (int ladderPos = 0; ladderPos < ladderMaxHeight; ladderPos++) {
            drawRandomLine(ladderPos);
        }
    }

    public void drawRadder(int row, int col) {
        lines[row][col] = 1;
        lines[row][col + 1] = 1;
    }

    private void drawRandomLine(int ladderPos) {
        for (int playerPos = 0; playerPos < playerCount - 1; playerPos++) {
            drawRandomRadder(ladderPos, playerPos);
        }
    }

    private void drawRandomRadder(int ladderPos, int playerPos) {
        if (isRandomDraw())
            drawRadder(ladderPos, playerPos);
    }

    private boolean isRandomDraw() {
        return rnd.nextBoolean();
    }
}
