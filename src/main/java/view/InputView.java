package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int inputPeopleNumber() {
        return sc.nextInt();
    }

    public static int inputLadderHeight() {
        return sc.nextInt();
    }
}
