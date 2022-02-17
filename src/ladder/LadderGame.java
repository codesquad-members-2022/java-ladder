package ladder;

import java.util.List;

public class LadderGame {

    private List<String> participants;
    private int[][] ghostLeg;
    private OutputView ov;

    public LadderGame(List<String> participants, int LegLength) {
        this.participants = participants;
        int numberOfParticipants = participants.size();
        this.ghostLeg = creatGhostLeg(numberOfParticipants, LegLength);
        this.ov = new OutputView(numberOfParticipants);
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
            insertElementAtColumn(arr[row], columnLength);
        }
        return arr;
    }

    private void insertElementAtColumn(int[] arr, int columnLength) {
        for (int column = 0; column < columnLength; column++) {
            arr[column] = insertElement(column);
        }
    }

    private int insertElement(int column) {
        if (column % 2 == 0) {
            return 2;
        }
        return (int) (Math.random() * 2);
    }

    public void start() {
        ov.printParticipants(participants);
        ov.printGhostLeg(ghostLeg);
    }
}