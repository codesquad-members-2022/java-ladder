package main.view;

import main.domain.LadderGame;

public class OutputView {

    private static final String EXECUTE_RESULT = "\n실행결과\n";
    private static final String ILLEGAL_INPUT = "\n이름은 최대 5글자까지만 입력 가능합니다.";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printGame(LadderGame ladderGame) {
        printMessage(EXECUTE_RESULT);
        System.out.println(ladderGame);
    }

    public static void printIllegalException() {
        printMessage(ILLEGAL_INPUT);
    }

}
