package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int inputLadderHeight() {
        PrintView.printLadderHeight();
        return inputIntValue();
    }

    private static int inputIntValue() {
        return sc.nextInt();
    }

    public static String inputPeopleName() {
        PrintView.printPeopleName();
        return sc.nextLine();
    }

    public static void close() {
        sc.close();
    }
}
