package ladder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        InputView pv = new InputView();

        pv.questionNumberOfParticipants();
        int numberOfParticipants = s.nextInt();

        pv.questionLegLength();
        int LegLength = s.nextInt();

        LadderGame gl = new LadderGame(numberOfParticipants,LegLength);
        gl.start();
    }
}
