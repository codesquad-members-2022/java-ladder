package main.Controller;

import java.util.Arrays;
import java.util.function.Consumer;

public class OutputController {
    private static final Consumer<String[]> printLadder = a -> {
        Arrays.stream(a).forEach(System.out::println);
        System.out.println("");
    };
    public static void showUserInputMsg() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public static void showHeightInputMsg() {
        System.out.println("최대 사다리 높이는 몇 층인가요?");
    }

    public static void showLadder(String[][] ladderArr) {
        Arrays.stream(ladderArr).forEach(printLadder);
    }
}
