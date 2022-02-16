package main.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private InputController() {
    }

    public static int inputNumber(String msg) throws IOException {
        printMessage(msg);
        return Integer.parseInt(br.readLine());
    }

    public static String[] inputStringWithDelimiter(String msg, String delimiter) throws IOException {
        printMessage(msg);
        return br.readLine().split(delimiter);
    }

    private static void printMessage(String msg) {
        System.out.println(msg);
    }

    public static void close() throws IOException {
        br.close();
    }
}
