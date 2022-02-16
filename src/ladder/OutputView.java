package ladder;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private List<String> stringElements;

    public OutputView() {
        stringElements = new ArrayList<>();
        stringElements.add(" ");
        stringElements.add("-");
        stringElements.add("|");
    }

    public void printGhostLeg(int[][] ghostLeg) {
        for (int row = 0; row < ghostLeg.length; row++) {
            printColumn(ghostLeg[row]);
            System.out.println();
        }
    }

    private void printColumn(int[] ghostLeg) {
        for (int column = 0; column < ghostLeg.length; column++) {
            printElements(ghostLeg[column]);
        }
    }

    private void printElements(int element) {
        String stringElement = stringElements.get(element);
        System.out.print(stringElement);
    }
}
