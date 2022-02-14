package ladder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Ladder ladder = new Ladder();
        Output output = new Output();
        output.printLadder(ladder.makeLadder(input.getParam()));
    }
}
