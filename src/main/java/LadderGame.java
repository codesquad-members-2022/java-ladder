public class LadderGame {

    private final int peopleCount;
    private final int ladderHeight;
    private final char[][] ladderBoard;

    public LadderGame(int peopleCount, int ladderHeight) {
        this.peopleCount = peopleCount;
        this.ladderHeight = ladderHeight;
        this.ladderBoard = new char[ladderHeight][peopleCount + 2];
        initBoard();
    }

    public void start() {
        makeRandomLadder();
        for (char[] chars : ladderBoard) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private void initBoard() {
        for (int i = 0; i < ladderHeight; i++) {
            for (int j = 0; j < peopleCount + 2; j+=2) {
                ladderBoard[i][j] = '|';
            }
        }
    }

    private void makeRandomLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            for (int j = 1; j < peopleCount + 2; j+=2) {
                ladderBoard[i][j] = '-';
            }
        }
    }
}
