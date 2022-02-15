import java.util.Random;

public class LadderGame {

    private static final Random random = new Random();

    private String[][] ladder;

    public void start() {
        int playerCount = Input.inputRules("참여할 사람은 몇 명인가요?");
        int ladderHeight = Input.inputRules("최대 사다리 높이는 몇 개인가요?");

        createLadder(playerCount, ladderHeight);
    }

    private void createLadder(int playerCount, int ladderHeight) {
        ladder = new String[ladderHeight][(playerCount * 2) - 1];

        for (int i = 0; i < ladder.length; i++) {
            addLadderData(ladder, i);
        }
    }

    private static void addLadderData(String[][] ladder, int i) {
        for (int j = 0; j < ladder[i].length; j++) {
            ladder[i][j] = check(ladder, i, j);
        }
    }

    private static String check(String[][] ladder, int i, int j) {
        if (j == 0 || j % 2 == 0) {
            return "|";
        }

        if (random.nextBoolean()) {
            return ladder[i][j] = "-";
        }

        return ladder[i][j] = " ";
    }

    public void getResult() {
        if (ladder == null) {
            System.out.println("진행된 게임이 없습니다.");
            return;
        }

        Output.printLadder(ladder);
    }

}
