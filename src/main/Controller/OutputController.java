package main.Controller;

import java.util.Arrays;
import java.util.function.Consumer;

public class OutputController {
    private static final Consumer<String[]> printLadder = a -> {
        Arrays.stream(a).forEach(System.out::println);
        System.out.println("");
    };
    public static void showLadder(String[][] ladderArr) {
        Arrays.stream(ladderArr).forEach(printLadder);
    }
}
