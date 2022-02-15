package ladder;

import java.util.Random;

public class Ladder {

    private final int userCount;
    private final int ladderHigh;
    private static final String[] ladderLineElement = {" ", "-", "-"};

    public Ladder(int userCount, int ladderHigh) {
        this.userCount = userCount;
        this.ladderHigh = ladderHigh;
        createLadder();
    }

    private void createLadder() {
        String[][] ladder = new String[ladderHigh][userCount + (userCount - 1)];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                if (j % 2 == 0) {
                    ladder[i][j] = "|";
                    continue;
                }
                ladder[i][j] = ladderLineElement[random.nextInt(3)];
                if (j != 1 && ladder[i][j - 2].equals(ladderLineElement[1])) {
                    ladder[i][j] = ladderLineElement[0];
                }
            }
        }
        printLadder(ladder);
    }

    public void printLadder(String[][] ladder) {
        Screen screen = new Screen();
        screen.printLadder(ladder);
    }
}
