package ladder;

public class OutputView {
    private String row;
    private String column;
    private String empty;

    public OutputView() {
        this.row = "|";
        this.column = "-";
        this.empty = " ";

    }

    public void printGhostLeg(int[][] ghostLeg) {
        for (int row = 0; row < ghostLeg.length; row++) {
            for (int column = 0; column < ghostLeg[row].length; column++) {
                printElements(ghostLeg[row][column]);
            }
            System.out.println();
        }
    }

    private void printElements(int element) {
        if (element == 0) {
            System.out.print(empty);
            return;
        }
        if (element == 1) {
            System.out.print(column);
            return;
        }
        if (element == 2) {
            System.out.print(row);
            return;
        }
    }
}
