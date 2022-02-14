import java.util.Random;

public class Ladder {

    private Boolean[][] board;
    private int width;
    private int height;

    public Ladder(int width, int height) {
        this.width = width - 1;
        this.height = height;
        init();
    }

    public void init() {
        board = new Boolean[height][width];
        makeRandomLadder();
    }

    public void makeRandomLadder() {
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = random.nextBoolean();
            }
        }
    }

    public String ladderSign(boolean b) {
        if (b) {
            return "-";
        }
        return " ";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            sb.append("|");
            for (int j = 0; j < width; j++) {
                sb.append(ladderSign(board[i][j])).append("|");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
