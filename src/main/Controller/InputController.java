package main.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {
    public static int[] inputNumber() {
        int[] result = new int[2];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            showUserInputMsg();
            result[0] = Integer.parseInt(br.readLine());
            showHeightInputMsg();
            result[1] = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    private static void showUserInputMsg() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    private static void showHeightInputMsg() {
        System.out.println("최대 사다리 높이는 몇 층인가요?");
    }

}
