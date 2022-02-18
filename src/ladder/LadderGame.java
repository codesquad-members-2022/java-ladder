package ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private List<String> participants;
    private List<List<Integer>> ghostLeg;
    private OutputView ov;

    public LadderGame(List<String> participants, int LegLength) {
        this.participants = participants;
        int numberOfParticipants = participants.size();
        this.ghostLeg = creatGhostLeg(numberOfParticipants, LegLength);
        this.ov = new OutputView();
    }

    private List<List<Integer>> creatGhostLeg(int numberOfParticipants, int rowLength) {
        int columnLength = (numberOfParticipants * 2) - 1;
        List<List<Integer>> ghostLeg = new ArrayList<>(rowLength);
        for (int row = 0; row < rowLength; row++) {
            ghostLeg.add(new ArrayList<>());
            insertElementAtColumn(ghostLeg.get(row), columnLength);
        }
        return ghostLeg;
    }

    private void insertElementAtColumn(List<Integer> rowIndexList, int columnLength) {
        for (int column = 0; column < columnLength; column++) {
            insertElement(rowIndexList, column);
        }
    }

    private void insertElement(List<Integer> rowIndexList, int column) {
        if (column % 2 == 0) {
            rowIndexList.add(2);
            return;
        }
        CheckHorizontalLinesOverlap(rowIndexList, column);
    }

    private void CheckHorizontalLinesOverlap(List<Integer> rowIndexList, int column) {
        int random = (int) (Math.random() * 2);
        if (column == 1) {
            rowIndexList.add(random);
            return;
        }
        if (rowIndexList.get(column - 2) == 1) {
            rowIndexList.add(0);
            return;
        }
        rowIndexList.add(random);
    }

    public void start() {
        ov.printParticipants(participants);
        ov.printGhostLeg(ghostLeg);
    }
}