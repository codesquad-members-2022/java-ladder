package dukcode.ladder.view;

import dukcode.ladder.Ladder;

public class LadderView {
    private static final int MAX_STR_LEN = 7;
    private static final String SIDE_RAIL = "|";
    private static final String STEP = "-".repeat(MAX_STR_LEN);
    private static final String BLANK_BETWEEN_NAME = " ".repeat(SIDE_RAIL.length());
    private static final String LEFT_BLANK_WITH_SIDE_RAIL = " ".repeat(MAX_STR_LEN / 2).concat(SIDE_RAIL);
    private static final String BLANK_BETWEEN_SIDE_RAIL = " ".repeat(MAX_STR_LEN);
    private static final String ELLIPSIS = "..";

    private final Ladder ladder;

    public LadderView(Ladder ladder) {
        this.ladder = ladder;
    }

    public String[] getPlayersNameArray() {
        return ladder.getNamePlayers();
    }

    public String[] getResultsArray() {
        return ladder.getResults();
    }

    public String getPlayersName() {
        final String[] namePlayers = this.ladder.getNamePlayers();
        return getConsecutiveString(namePlayers);
    }

    public String getResults() {
        final String[] results = this.ladder.getResults();
        return getConsecutiveString(results);
    }

    private String getConsecutiveString(String[] strArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArray.length; ++i) {
            strArray[i] = getStringWithEllipsis(strArray[i]);
            strArray[i] = getStringWithPadding(strArray[i]);
            sb.append(strArray[i].concat(BLANK_BETWEEN_NAME));
        }

        return new String(sb);
    }

    private String getStringWithEllipsis(String str) {
        if (str.length() <= MAX_STR_LEN) {
            return str;
        }

        return str.substring(0, MAX_STR_LEN - ELLIPSIS.length()).concat(ELLIPSIS);
    }

    private String getStringWithPadding(String str) {
        int count = 0;
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < MAX_STR_LEN) {
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
        sb.setLength(sb.length() - 1);
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

    public String getStringResultOfPlayer(String namePlayer) {
        int playerIdx = ladder.getPlayerIdx(namePlayer);
        int resultIdx = ladder.getResultIdx(playerIdx);
        return ladder.getResults()[resultIdx];
    }
}