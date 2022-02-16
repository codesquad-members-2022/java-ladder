package ladder;

public class LadderGame {

    private int[][] ghostLeg;
    private OutputView ov;

    public LadderGame(int numberOfParticipants, int LegLength) {
        this.ghostLeg = creatGhostLeg(numberOfParticipants, LegLength);
        this.ov = new OutputView();
    }

    private int[][] creatGhostLeg(int numberOfParticipants, int LegLength) {
        int rowLength = LegLength;
        int columnLength = (numberOfParticipants * 2) - 1;
        int[][] ghostLeg = createArr(rowLength, columnLength);
        return ghostLeg;
    }

    private int[][] createArr(int rowLength, int columnLength) {
        int[][] arr = new int[rowLength][columnLength];
        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                arr[row][column] = insertElement(column);
            }
        }
        return arr;
    }

    private int insertElement(int column) {
        if (column % 2 == 0) {
            return 2;
        }
        return  (int) (Math.random() * 2);
    }

    public void start() {
        ov.printGhostLeg(ghostLeg);
    }
}