package main.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {
    public static int[] inputNumber() {
        int[] result = new int[2];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            OutputController.showUserInputMsg();
            result[0] = Integer.parseInt(br.readLine());
            OutputController.showHeightInputMsg();
            result[1] = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
