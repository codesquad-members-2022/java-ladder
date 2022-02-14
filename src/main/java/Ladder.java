import java.util.Random;

public class Ladder {

    private static final String PILLAR = "|";
    private static final String LINE = "-";
    private static final String EMPTY = " ";
    private static final Random random = new Random();

    private final String[][] ladder;

    private boolean isPillar(int col) {
        return col % 2 == 0;
    }

    private String createRandomLine() {
        int n = random.nextInt(2);
        return (n == 0) ? EMPTY : LINE;
    }

    public Ladder(int entry, int height) {
        int width = entry + (entry - 1);
        this.ladder = new String[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (isPillar(col)) {
                    ladder[row][col] = PILLAR;
                } else {
                    ladder[row][col] = createRandomLine();
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String[] row : ladder) {
            for (String col : row) {
                sb.append(col);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
