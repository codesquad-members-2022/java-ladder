package ladder;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private List<String> stringElements;

    public OutputView() {
        stringElements = new ArrayList<>();
        stringElements.add("     ");
        stringElements.add("-----");
        stringElements.add("|");
    }

    public void printGhostLeg(List<List<Integer>> ghostLeg) {
        for (int row = 0; row < ghostLeg.size(); row++) {
            System.out.print("   ");
            printColumn(ghostLeg.get(row));
            System.out.println();
        }
    }

    private void printColumn(List<Integer> rowIndexList) {
        for (int column = 0; column < rowIndexList.size(); column++) {
            printElements(rowIndexList.get(column));
        }
    }

    private void printElements(int element) {
        String stringElement = stringElements.get(element);
        System.out.print(stringElement);
    }

    public void printParticipants(List<String> participants) {
        for (String participant: participants) {
            System.out.printf("%5s",participant);
            System.out.print(' ');
        }
        System.out.println();
    }
}
