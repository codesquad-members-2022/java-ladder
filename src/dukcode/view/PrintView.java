package dukcode.view;

import dukcode.model.Ladder;

public class PrintView {
    private static final int MAX_NAME_LEN = 7;
    private static final String SIDE_RAIL = "|";
    private static final String STEP = "-".repeat(MAX_NAME_LEN);
    private static final String BLANK_BETWEEN_NAME = " ".repeat(SIDE_RAIL.length());
    private static final String LEFT_BLANK_WITH_SIDE_RAIL = " ".repeat(MAX_NAME_LEN / 2).concat(SIDE_RAIL);
    private static final String BLANK_BETWEEN_SIDE_RAIL = " ".repeat(MAX_NAME_LEN);
    private static final String ELLIPSIS = "..";

    private final Ladder ladder;

    public PrintView(Ladder ladder) {
        this.ladder = ladder;
    }

    public void printGame() {
        final String[] namePlayer = this.ladder.getNamePlayers();
        final Boolean[][] ladder = this.ladder.getLadder();
        final int height = this.ladder.getHeight();
        final int numSteps = this.ladder.getNumSteps();

        System.out.println("\n실행결과\n");
        printPlayerName(namePlayer);
        printLadder(ladder, height, numSteps);

    }

    private void printPlayerName(String[] namePlayers) {
        for (int i = 0; i < namePlayers.length; ++i) {
            namePlayers[i] = namePlayers[i].trim();
            namePlayers[i] = makeNameWithEllipsis(namePlayers[i]);
            namePlayers[i] = makeNameWithPadding(namePlayers[i]);
            System.out.print(namePlayers[i].concat(BLANK_BETWEEN_NAME));
        }
        System.out.println();
    }

    private String makeNameWithEllipsis(String name) {
        if (name.length() <= MAX_NAME_LEN) {
            return name;
        }

        return name.substring(0, MAX_NAME_LEN - ELLIPSIS.length()).concat(ELLIPSIS);
    }

    // TODO : LinkedList 이용해 구현
    private String makeNameWithPadding(String name) {
        int count = 0;
        StringBuilder sb = new StringBuilder(name);
        while (sb.length() < MAX_NAME_LEN) {
            if (count % 2 == 0) {
                sb.insert(0, ' ');
            } else {
                sb.append(' ');
            }
            count++;
        }

        return new String(sb);
    }

    private void printLadder(Boolean[][] ladder, int height, int numSteps) {
        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < height; ++line) {
            sb.append(getStringLine(ladder[line], numSteps));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private StringBuilder getStringLine(Boolean[] line, int numSteps) {
        StringBuilder strLine = new StringBuilder(LEFT_BLANK_WITH_SIDE_RAIL);
        for (int step = 0; step < numSteps; ++step) {
            strLine.append(line[step] ? STEP : BLANK_BETWEEN_SIDE_RAIL);
            strLine.append(SIDE_RAIL);
        }

        return strLine;
    }

}
