package main.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private InputController() {
    }

    public static int inputNumber(String msg) {
        int result = 0;
        try {
            printMessage(msg);
            result = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static void printMessage(String msg) {
        System.out.println(msg);
    }

    public static void close() throws IOException {
        br.close();
    }
}
