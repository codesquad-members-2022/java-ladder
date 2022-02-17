package main.view;

import java.util.List;
import java.util.stream.Collectors;
import main.domain.LadderGame;
import main.domain.Player;

public class OutputView {

    private static final String EXECUTE_RESULT = "\n실행결과\n";
    private static final String ILLEGAL_INPUT = "\n이름은 최대 5글자까지만 입력 가능합니다.";
    private static final String ILLEGAL_NUMBER = "\n숫자를 입력해주세요.";
    private static final String GAME_END = "\n게임을 종료합니다.";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printGame(LadderGame game) {
        printMessage(EXECUTE_RESULT);
        System.out.println(game);
    }

    public static void printIllegalException() {
        printMessage(ILLEGAL_INPUT);
    }

    public static void printNumberException() {
        printMessage(ILLEGAL_NUMBER);
    }

    public static void printEnd() {
        printMessage(GAME_END);
    }

    public static void printPlayers(List<Player> players) {
        StringBuilder sb = new StringBuilder();

        for (Player player : players) {
            appendPlayer(sb, player);
        }
        printMessage(sb.toString());
    }

    private static void appendPlayer(StringBuilder sb, Player player) {
        sb.append(player.getName())
            .append(" : ")
            .append(player.getOutcome())
            .append("\n");
    }

}
