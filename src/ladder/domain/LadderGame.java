package ladder.domain;

public class LadderGame {
    private static final String BLANK = "     ";
    private static final String STEP = "-----";
    private static final String RAIL = "|";
    private static final String LEFT_MARGIN = "  ";
    private static final String DEFAULT_NAME = "men";

    private final int countOfPlayer;
    private final String[] playerNames;
    private final Ladder ladder;

    public LadderGame(int countOfPlayer, int height, String[] playerNames) {
        this.countOfPlayer = countOfPlayer;
        this.playerNames = playerNames;
        ladder = new Ladder(countOfPlayer, height);
    }

    public void printLadderGame() {
        printUserNames();
        for (Line line : ladder.getLadderArr()) {
            printSingleLine(line);
        }
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
        for (int i = 0; i < playerNames.length; i++) {
            printUserName(playerNames[i]);
        }

        for (int i = playerNames.length; i < countOfPlayer; i++) {
            String playerName = DEFAULT_NAME + i;
            printUserName(playerName);
        }
        printNewLine();
    }

    private void printUserName(String playerName) {
        System.out.printf("%5.5s ", playerName);
    }
}
