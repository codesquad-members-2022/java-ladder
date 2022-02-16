public class LadderGame {

    private char[][] ladder;

    public void start() {
        int playerCount = Input.value("참여할 사람은 몇 명인가요?");
        int ladderHeight = Input.value("최대 사다리 높이는 몇 개인가요?");

        Input.close();

        init(playerCount, ladderHeight);

        createLadder();
    }

    private void init(int playerCount, int height) {
        int width = (playerCount * 2) - 1;

        ladder = new char[height][width];
    }

    private void createLadder() {
        for (int row = 0; row < ladder.length; row++) {
            addLadderData(row);
        }
    }

    private void addLadderData(int row) {
        for (int col = 0; col < ladder[row].length; col++) {
            ladder[row][col] = check(col);
        }
    }

    private char check(int j) {
        if (j == 0 || j % 2 == 0) {
            return '|';
        }

        if (Random.nextBoolean()) {
            return '-';
        }

        return ' ';
    }

    public void getResult() {
        if (ladder == null) {
            System.out.println("진행된 게임이 없습니다.");
            return;
        }

        Output.printLadder(ladder);
    }

}
