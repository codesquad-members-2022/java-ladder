package ladder;

public class OutputView {
    public void printGhostLeg(int[][] ghostLeg) {
        for (int i = 0; i < ghostLeg.length; i++) {
            System.out.print("|");
            for (int j = 1; j < ghostLeg[i].length; j += 2) {
                if (ghostLeg[i][j] == 1) {
                    System.out.print("-");
                }else {
                    System.out.print(" ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }
}
