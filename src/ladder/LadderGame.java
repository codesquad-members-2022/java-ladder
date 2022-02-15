package ladder;

public class LadderGame {

    private int[][] ghostLeg;
    private PrintView printView;

    public LadderGame(int numberOfParticipants, int LegLength) {
        this.ghostLeg = creatGhostLeg(numberOfParticipants, LegLength);
        this.printView = new PrintView();
    }

    private int[][] creatGhostLeg(int numberOfParticipants, int LegLength) {
        int row = LegLength;
        int column = numberOfParticipants + (numberOfParticipants - 1);
        int[][] ghostLeg = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j += 2) {
                ghostLeg[i][j] = 1;
            }
            for (int j = 1; j < column; j += 2) {
                ghostLeg[i][j] = (int) (Math.random() * 2);
            }
        }
        return ghostLeg;
    }

    public void start() {
        printView.printGhostLeg(ghostLeg);
    }
}
