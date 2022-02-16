package ladder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView pv = new InputView(scanner);
        LadderGame gl = new LadderGame(pv.getParticipants(), pv.getLadderHeight());
        gl.start();
        scanner.close();
    }
}
