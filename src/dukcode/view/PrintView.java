package dukcode.view;

import dukcode.model.Ladder;

public class PrintView {
    private static final String SIDE_RAIL = "|";
    private static final String STEP = "-----";
    private static final String BLANK = "     ";

    private final Ladder ladder;

    public PrintView(Ladder ladder) {
        this.ladder = ladder;
    }

    public void printLadder() {
        final boolean[][] ladder = this.ladder.getLadder();
        final int height = this.ladder.getHeight();
        final int numSteps = this.ladder.getNumSteps();

        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < height; ++line) {
            sb.append(getStringLine(ladder[line], numSteps));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private StringBuilder getStringLine(boolean[] line, int numSteps) {
        StringBuilder strLine = new StringBuilder(SIDE_RAIL);
        for (int step = 0; step < numSteps; ++step) {
            strLine.append(line[step] ? STEP : BLANK);
            strLine.append(SIDE_RAIL);
        }

        return strLine;
    }

}
