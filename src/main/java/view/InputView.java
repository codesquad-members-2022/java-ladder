package view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static int inputPeopleNumber() {
        PrintView.requestPeopleNumber();
        return inputIntValue();
    }

    public static int inputLadderHeight() {
        PrintView.requestLadderHeight();
        return inputIntValue();
    }

    private static int inputIntValue() {
        return sc.nextInt();
    }

    public static void scannerClose() {
        sc.close();
    }

    public static String inputPeopleName() {
        return sc.nextLine();
    }
}
