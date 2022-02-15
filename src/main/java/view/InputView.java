package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int inputLadderHeight() {
        PrintView.requestLadderHeight();
        return inputIntValue();
    }

    private static int inputIntValue() {
        return sc.nextInt();
    }

    public static String inputPeopleName() {
        PrintView.requestPeopleName();
        return sc.nextLine();
    }

    public static void scannerClose() {
        sc.close();
    }
}
