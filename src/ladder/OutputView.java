package ladder;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private List<String> stringElements;

    public OutputView(int numberOfParticipants) {
        stringElements = new ArrayList<>();
        stringElements.add(drawSymbol(" ",numberOfParticipants));
        stringElements.add(drawSymbol("-",numberOfParticipants));
        stringElements.add("|");
    }

    private String drawSymbol(String symbol,int numberOfParticipants) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfParticipants; i++) {
            sb.append(symbol);
        }
        return sb.toString();
    }

    public void printGhostLeg(int[][] ghostLeg) {
        for (int row = 0; row < ghostLeg.length; row++) {
            System.out.print("   ");
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

    public void printParticipants(List<String> participants) {
        for (String participant: participants) {
            System.out.printf("%5s",participant);
            System.out.print(' ');
        }
        System.out.println();
    }
}
