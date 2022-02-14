import view.PrintView;

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

    private void initBoard() {
        for (int i = 0; i < ladderHeight; i++) {
            putInitWidth(i);
        }
    }

    private void putInitWidth(int height) {
        for (int j = 0; j < peopleCount + 2; j+=2) {
            ladderBoard[height][j] = '|';
        }
    }

    public void start() {
        makeRandomLadder();
        PrintView.showLadder(ladderBoard);
    }

    private void makeRandomLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            makeRow(i);
        }
    }

    private void makeRow(int i) {
        for (int j = 1; j < peopleCount + 2; j+=2) {
            putRandomLine(i, j);
        }
    }

    private void putRandomLine(int i, int j) {
        if (isPutLine()) {
            ladderBoard[i][j] = '-';
            return;
        }
        ladderBoard[i][j] = ' ';
    }

    private boolean isPutLine() {
        return makeRandomValue() > 5;
    }

    private int makeRandomValue() {
        return (int)(Math.random() * 10 + 1);
    }
}
