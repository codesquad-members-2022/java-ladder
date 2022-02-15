import java.util.Random;

public class Ladder {
    private int memberCount;
    private int height;
    private String[][] ladder;


    public Ladder(int memberCount, int height) {
        ladder = new String[height][(memberCount * 2) - 1];
        this.height = height;
        this.memberCount = memberCount;
        this.ladder = createLadder();
    }

    private String[][] createLadder() {
        ladder = new String[height][(memberCount * 2) - 1];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < ladder[h].length; w++) {
                if (w % 2 == 0) {
                    ladder[h][w] = "|";
                }
                if (w % 2 == 1) {
                    ladder[h][w] = "    ";
                }
            }
        }
        createLine(ladder);
        return ladder;
    }

    private void createLine(String[][] ladder) {
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < ladder[h].length; w++) {
                Random random = new Random();
                boolean randomLine = random.nextBoolean();
                if (w % 2 == 1 && randomLine == true) {
                    this.ladder[h][w] = "----";
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int h = 0; h < height; h++) {
            for (int w = 0; w <ladder[h].length; w++) {
                sb.append(ladder[h][w]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
