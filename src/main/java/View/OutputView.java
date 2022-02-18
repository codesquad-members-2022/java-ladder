package View;

import domain.Ladder;
import domain.LadderGame;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String END_MESSAGE = "게임을 종료합니다.";

    public static void showLadder(LadderGame ladderGame) {
        System.out.println(ladderGame.game2Text());
    }

    public static void showTargetResult(LadderGame ladderGame, String name) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        System.out.println(ladderGame.findResult(name));
        System.out.println();
    }

    public static void showAllResult(LadderGame ladderGame) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        System.out.println(ladderGame.getAllResult());
        System.out.println();
    }

    public static void closeGame() {
        System.out.println(END_MESSAGE);
    }
}

