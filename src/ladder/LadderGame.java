package ladder;

public class LadderGame {

    private int[][] ghostLeg;
    private OutputView ov;

    public LadderGame(int numberOfParticipants, int LegLength) {
        this.ghostLeg = creatGhostLeg(numberOfParticipants, LegLength);
        this.ov = new OutputView();
    }

    private int[][] creatGhostLeg(int numberOfParticipants, int LegLength) {
        int row = LegLength;
        int column = numberOfParticipants + (numberOfParticipants - 1);
        int[][] ghostLeg = createArr(row,column);
        return ghostLeg;
    }

    private int[][] createArr(int row, int column) {
        int[][] arr = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j += 2) {
                arr[i][j] = 1;
            }
            for (int j = 1; j < column; j += 2) {
                arr[i][j] = (int) (Math.random() * 2);
            }
        }
        return arr;
    }

    public void start() {
        ov.printGhostLeg(ghostLeg);
    }
}