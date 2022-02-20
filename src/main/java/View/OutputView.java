package View;

import domain.LadderGame;
import domain.Players;

import java.util.Arrays;
import java.util.Map;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String END_MESSAGE = "게임을 종료합니다.";
    private static final String NAME_ERROR_MESSAGE = "찾으시는 플레이어가 없습니다.";
    private static final String START_VERTICAL = "    |";
    private static final String BLANK = "     |";
    private static final String STEP = "-----|";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String KEY_VALUE_DELIMITER = " : ";

    public static void showPlayerNames(Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        players.getNames().forEach(name -> stringBuilder.append(String.format("%6s", name)));
        System.out.println(stringBuilder.toString());
    }

    public static void showLadder(Ladder ladder) {
        System.out.println(drawLadder(ladder));
    }

    public static void showResults(String[] results) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(results).forEach(result -> stringBuilder.append(String.format("%6s", result)));
        System.out.println(stringBuilder.toString());
    }

    public static void showTargetResult(LadderGame ladderGame, String name) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(NEW_LINE).append(RESULT_MESSAGE).append(NEW_LINE)
                .append(name).append(KEY_VALUE_DELIMITER).append(ladderGame.findResult(name))
                .append(NEW_LINE);
        System.out.println(stringBuilder.toString());
    }

    public static void showAllResult(Map<String, String> resultMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(NEW_LINE);
        resultMap.keySet().stream().forEach(name -> stringBuilder.append(name).append(KEY_VALUE_DELIMITER)
                .append(resultMap.get(name)).append(NEW_LINE));
        System.out.println(stringBuilder.toString());
    }

    public static void closeGame() {
        System.out.println(END_MESSAGE);
    }

    public static void showNameError() {
        System.out.println(NAME_ERROR_MESSAGE);
    }

    private static String drawLadder(Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        int height = ladder.getLadderHeight();
        for (int i = 0; i < height; i++) {
            stringBuilder.append(START_VERTICAL);
            drawFloor(stringBuilder, ladder, i);
        }
        return stringBuilder.toString();
    }

    private static void drawFloor(StringBuilder stringBuilder, Ladder ladder, int indexOfFloor) {
        for (int j = 0; j < ladder.getWidth(); j++) {
            stringBuilder.append(drawLadderElement(ladder.isStep(indexOfFloor, j)));
        }
        stringBuilder.append(NEW_LINE);
    }

    private static String drawLadderElement(Boolean isStep) {
        if (isStep) {
            return STEP;
        }
        return BLANK;
    }
}

