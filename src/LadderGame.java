import java.util.Random;

public class LadderGame {

    private static final Random random = new Random();

    private String[][] ladder;
    private int width;
    private int height;

    public void start() {
        int playerCount = Input.inputRules("참여할 사람은 몇 명인가요?");
        int ladderHeight = Input.inputRules("최대 사다리 높이는 몇 개인가요?");

        Input.close();

        init(playerCount, ladderHeight);

        createLadder();
    }

    private void init(int playerCount, int ladderHeight) {
        this.width = (playerCount * 2) - 1;
        this.height = ladderHeight;
    }

    private void createLadder() {
        ladder = new String[height][width];

        for (int i = 0; i < ladder.length; i++) {
            addLadderData(i);
        }
    }

    private void addLadderData(int i) {
        for (int j = 0; j < ladder[i].length; j++) {
            ladder[i][j] = check(i, j);
        }
    }

    private String check(int i, int j) {
        if (j == 0 || j % 2 == 0) {
            return "|";
        }

        if (random.nextBoolean()) {
            return "-";
        }

        return " ";
    }

    public void getResult() {
        if (ladder == null) {
            System.out.println("진행된 게임이 없습니다.");
            return;
        }

        Output.printLadder(ladder);
    }

}
