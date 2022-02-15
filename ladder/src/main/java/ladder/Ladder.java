package ladder;

import java.util.Random;

public class Ladder {

    private final int userCount;
    private final int ladderHeight;
    private static final String PILLAR = "|";
    private static final String SPACE = " ";
    private static final String LINE = "-";
    private final String[] ladderUnit = {SPACE, LINE, LINE};

    public Ladder(int userCount, int ladderHigh) {
        this.userCount = userCount;
        this.ladderHeight = ladderHigh;
        createLadder();
    }

    private void createLadder() {
        String[][] ladder = new String[ladderHeight][ladderWidth()];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                if (j % 2 == 0) {
                    ladder[i][j] = PILLAR;
                    continue;
                }
                ladder[i][j] = ladderUnit[random.nextInt(ladderUnit.length)];
                if (j != 1 && ladder[i][j - 2].equals(ladderUnit[1])) {
                    ladder[i][j] = ladderUnit[0];
                }
            }
        }
        printLadder(ladder);
    }

    private int ladderWidth() {
        return userCount + (userCount - 1);
    }

    public void printLadder(String[][] ladder) {
        Output output = new Output();
        output.printLadder(ladder);
    }
}
