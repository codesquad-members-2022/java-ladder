package main;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getNames() {
        OutputView.printMessage(Message.INPUT_NAMES.get());
        return scanner.nextLine();
    }

    public static int getNumLadder() {
        OutputView.printMessage(Message.INPUT_NUM_LADDER.get());
        return scanner.nextInt();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
