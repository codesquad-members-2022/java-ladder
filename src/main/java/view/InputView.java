package view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc;

    public static int inputPeopleNumber() {
        PrintView.requestPeopleNumber();
        return inputIntValue();
    }

    public static int inputLadderHeight() {
        PrintView.requestLadderHeight();
        return inputIntValue();
    }

    private static int inputIntValue() {
        sc = new Scanner(System.in);
        int value = sc.nextInt();
        sc.close();
        return value;
    }
}
