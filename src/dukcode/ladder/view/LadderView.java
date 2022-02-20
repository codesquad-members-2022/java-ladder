package dukcode.ladder.view;

import dukcode.ladder.Ladder;

public class LadderView {
    private static final int MAX_NAME_LEN = 7;
    private static final String SIDE_RAIL = "|";
    private static final String STEP = "-".repeat(MAX_NAME_LEN);
    private static final String BLANK_BETWEEN_NAME = " ".repeat(SIDE_RAIL.length());
    private static final String LEFT_BLANK_WITH_SIDE_RAIL = " ".repeat(MAX_NAME_LEN / 2).concat(SIDE_RAIL);
    private static final String BLANK_BETWEEN_SIDE_RAIL = " ".repeat(MAX_NAME_LEN);
    private static final String ELLIPSIS = "..";

    private final Ladder ladder;

    public LadderView(Ladder ladder) {
        this.ladder = ladder;
    }

    public String getPlayersName() {
        final String[] namePlayers = this.ladder.getNamePlayers();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < namePlayers.length; ++i) {
            namePlayers[i] = makeNameWithEllipsis(namePlayers[i]);
            namePlayers[i] = makeNameWithPadding(namePlayers[i]);
            sb.append(namePlayers[i].concat(BLANK_BETWEEN_NAME));
        }

        return new String(sb);
    }

    private String makeNameWithEllipsis(String name) {
        if (name.length() <= MAX_NAME_LEN) {
            return name;
        }

        return name.substring(0, MAX_NAME_LEN - ELLIPSIS.length()).concat(ELLIPSIS);
    }

    private String makeNameWithPadding(String name) {
        int count = 0;
        StringBuilder sb = new StringBuilder(name);
        while (sb.length() < MAX_NAME_LEN) {
            sb = getStringPaddingOnce(sb, count);
            count++;
        }

        return new String(sb);
    }
    
    private StringBuilder getStringPaddingOnce(StringBuilder sb, int count) {
        if (count % 2 == 0) {
            return sb.insert(0, ' ');
        }

        return sb.append(' ');
    }

    public String getLadderString() {
        final Boolean[][] ladder = this.ladder.getLadder();
        final int height = this.ladder.getHeight();
        final int numSteps = this.ladder.getNumSteps();

        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < height; ++line) {
            sb.append(getStringLine(ladder[line], numSteps));
            sb.append("\n");
        }

        return new String(sb);
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