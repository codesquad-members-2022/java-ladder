package ladder;

public class InputView {
    private String participantsQuestion = "참여할 사람은 몇 명인가요?";
    private String legsQuestion = "사다리의 높이는 얼마인가요?";

    public void questionNumberOfParticipants() {
        System.out.println(participantsQuestion);
    }

    public void  questionLegLength () {
        System.out.println(legsQuestion);
    }

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
