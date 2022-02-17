package main.view;

import java.util.List;
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

    public static void printPlayers(String line, List<Player> players) {
        StringBuilder sb = new StringBuilder();

        if (line.equals("all")) {
            appendPlayers(sb, players);
        } else {
            appendPlayer(sb, players.get(0));
        }
        printMessage(sb.toString());
    }

    public static void appendPlayers(StringBuilder sb, List<Player> players) {
        for (Player player : players) {
            appendPlayer(sb, player);
        }
    }

    public static void appendPlayer(StringBuilder sb, Player player) {
        sb.append(player.getName())
            .append(" : ")
            .append(player.getOutcome())
            .append("\n");
    }

}
