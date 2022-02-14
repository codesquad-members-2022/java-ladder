package ladder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PrintView pv = new PrintView();

        pv.questionNumberOfParticipants();
        int numberOfParticipants = s.nextInt();

        pv.questionLegLength();
        int LegLength = s.nextInt();

        LadderGame gl = new LadderGame(numberOfParticipants,LegLength);
        gl.start();
    }
}
