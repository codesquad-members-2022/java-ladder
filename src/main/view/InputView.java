package main.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public static int giveInt() {
        int num = getInt();
        isPositiveInt(num);
        return num;
    }

    public static void close() {
        scanner.close();
    }

    public static int getInt() throws InputMismatchException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Incorrect input: an integer is required");
        }
    }

    public static void isPositiveInt(int num) {
        if (num <= 0){
            throw new IllegalArgumentException("Incorrect input: positive integer is required");
        }
    }
}
