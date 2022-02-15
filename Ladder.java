import java.util.Arrays;
import java.util.Random;

public class Ladder {
    private String[][] ladder;
    private Random random;

    public Ladder(int numberOfPeople, int ladderDepth) {
        this.ladder = new String[ladderDepth][1];
        this.random = new Random();

        for (int i = 0; i < ladderDepth; i++) {
            ladder[i][0] = initLadderLow(numberOfPeople + (numberOfPeople - 1));
        }
    }

    private String initLadderLow(int LadderLine) {
        StringBuilder sb = new StringBuilder();

        // 열이 짝수라면 "|", 홀수라면 " " or "-" 입력
        for (int i = 0; i < LadderLine; i++) {
            if (i % 2 == 0) {
                sb.append("|");
                continue;
            }
            sb.append(initRandomLine());
        }
        return sb.toString();
    }

    private String initRandomLine() {
        if (random.nextBoolean()) {
            return "-";
        }
        return " ";
    }

    public String[][] getLadder() {
        return ladder;
    }
}
