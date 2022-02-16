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
        for (int i = 0; i < ghostLeg.length; i++) {
            for (int j = 0; j < ghostLeg[i].length; j++) {
                printElements(ghostLeg[i][j]);
            }
            System.out.println();
        }
    }

    private void printElements(int i) {
        if (i == 0) {
            System.out.print(empty);
            return;
        }
        if (i == 1) {
            System.out.print(column);
            return;
        }
        if (i == 2) {
            System.out.print(row);
            return;
        }
    }
}
