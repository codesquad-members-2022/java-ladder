package main.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public static int giveInt() {
        return scanner.nextInt();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
