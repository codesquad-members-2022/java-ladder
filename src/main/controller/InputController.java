package main.controller;

import main.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static InputValidator validator = new InputValidator();

    private InputController() {
    }

    public static int inputPositiveNumber(String msg) throws IOException {
        printMessage(msg);
        int posNumber = Integer.parseInt(br.readLine());
        validator.isPosNumber(posNumber);
        return posNumber;
    }

    public static String[] inputStringWithDelimiter(String msg, String delimiter, int max) throws IOException {
        printMessage(msg);
        String[] names = br.readLine().split(delimiter);
        validator.isInRange(names, max);
        return names;
    }

    private static void printMessage(String msg) {
        System.out.println(msg);
    }

    public static void close() throws IOException {
        br.close();
    }
}
