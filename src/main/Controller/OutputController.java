package main.Controller;

import java.util.Arrays;
import java.util.function.Consumer;

public class OutputController {

    private OutputController() {
    }

    private static final Consumer<Character[]> printLadder = a -> {
        Arrays.stream(a).forEach(System.out::print);
        System.out.println("");
    };
    public static void showLadder(Character[][] ladderArr) {
        Arrays.stream(ladderArr).forEach(printLadder);
    }
}
