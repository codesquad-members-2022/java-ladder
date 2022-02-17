package ladder.domain;

import java.util.List;

public class LadderGame {
    private static final String LEFT_MARGIN = "  ";
    private static final String DEFAULT_NAME = "men";

    private final int playerNum;
    private final String[] playerNames;
    private final Ladder ladder;

    public LadderGame(int playerNum, int height, String[] playerNames) {
        this.playerNum = playerNum;
        this.playerNames = playerNames;
        int width = playerNum * 2 - 1;
        ladder = new Ladder(width, height);
    }

    public void printLadderGame() {
        printUserNames();
        for (List<String> strings : ladder.getLadderArr()) {
            printSingleUnit(strings);
        }
    }

    private void printSingleUnit(List<String> strings) {
        System.out.print(LEFT_MARGIN);
        strings.stream().forEach(System.out::print);
        System.out.println("");
    }

    private void printUserNames() {
        for (int i = 0; i < playerNames.length; i++) {
            printUserName(playerNames[i]);
        }

        for (int i = playerNames.length; i < playerNum; i++) {
            String playerName = DEFAULT_NAME + i;
            printUserName(playerName);
        }
        System.out.println("");
    }

    private void printUserName(String playerName) {
        System.out.printf("%5s ", playerName);
    }
}
