package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private static final String BLANK = "     ";
    private static final String STEP = "-----";
    private static final String RAIL = "|";
    private static final String LEFT_MARGIN = "  ";
    private static final String DEFAULT_NAME = "men";
    private static final String GET_ALL_RESULT_KEYWORD = "all";

    private final LadderGameInfo ladderGameInfo;
    private final Ladder ladder;
    private final Map<String, String> resultMap;

    public LadderGame(LadderGameInfo ladderGameInfo) {
        this.ladderGameInfo = ladderGameInfo;
        ladder = new Ladder(ladderGameInfo.getCountOfPlayer(), ladderGameInfo.getHeight());
        resultMap = play();
    }

    private HashMap<String, String> play() {
        HashMap<String, String> resultMap = new HashMap<>();
        String[] playerNames = ladderGameInfo.getPlayerNames();
        for (int indexOfPlayer = 0; indexOfPlayer < playerNames.length; indexOfPlayer++) {
            resultMap.put(playerNames[indexOfPlayer], ladderGameInfo.getResults()[ladder.getResult(indexOfPlayer)]);
        }
        return resultMap;
    }

    public void print() {
        printNewLine();
        printLadderMessage();
        printUserNames();
        for (Line line : ladder.getLadderArr()) {
            printSingleLine(line);
        }
        printResult();
        printNewLine();
    }

    private void printResultMap() {
        resultMap.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public void printResultMapByName(String userName) {
        printNewLine();
        System.out.println("실행 결과");
        if (userName.equals(GET_ALL_RESULT_KEYWORD)) {
            printResultMap();
            return;
        }
        System.out.println(resultMap.get(userName));
    }

    private void printLadderMessage() {
        System.out.println("사다리 결과");
    }

    private void printResult() {
        for (String result : ladderGameInfo.getResults()) {
            System.out.printf("%5s ", result);
        }
        printNewLine();
    }

    private void printSingleLine(Line line) {
        printLeftMargin();
        for (Boolean point : line.getPoints()) {
            draw(point);
        }
        printRail();
        printNewLine();
    }

    private void printNewLine() {
        System.out.printf("%n");
    }

    private void printRail() {
        System.out.printf(RAIL);
    }

    private void printLeftMargin() {
        System.out.printf(LEFT_MARGIN);
    }

    private void printBlank() {
        System.out.printf(BLANK);
    }

    private void draw(Boolean point) {
        printRail();
        if (Boolean.TRUE.equals(point)) {
            System.out.printf(STEP);
            return;
        }
        printBlank();
    }

    private void printUserNames() {
        for (int i = 0; i < ladderGameInfo.getPlayerNames().length; i++) {
            printUserName(ladderGameInfo.getPlayerNames()[i]);
        }

        for (int i = ladderGameInfo.getPlayerNames().length; i < ladderGameInfo.getCountOfPlayer(); i++) {
            String playerName = DEFAULT_NAME + i;
            printUserName(playerName);
        }
        printNewLine();
    }

    private void printUserName(String playerName) {
        System.out.printf("%5.5s ", playerName);
    }
}
