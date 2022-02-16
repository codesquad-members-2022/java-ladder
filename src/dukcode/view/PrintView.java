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
        final String[] namePlayer = this.ladder.getNamePlayers();
        final boolean[][] ladder = this.ladder.getLadder();
        final int height = this.ladder.getHeight();
        final int numSteps = this.ladder.getNumSteps();

        System.out.println("\n실행결과\n");
        printPlayerName(namePlayer);
        printLadder(ladder, height, numSteps);

    }

    private void printPlayerName(String[] namePlayer) {
        for (String name : namePlayer) {
            name = getNameWithPadding(name);
            System.out.print(name + " ");
        }
        System.out.println();
    }

    private String getNameWithPadding(String name) {
        int count = 0;
        while (name.length() < 5) {
            name = getNamePaddedOnce(name, count);
            count++;
        }

        return name;
    }

    private String getNamePaddedOnce(String name, int count) {
        if (count % 2 == 0) {
            return " " + name;
        } else if (count % 2 == 1) {
            return name + " ";
        }

        return name;
    }

    private void printLadder(boolean[][] ladder, int height, int numSteps) {
        StringBuilder sb = new StringBuilder();
        for (int line = 0; line < height; ++line) {
            sb.append(getStringLine(ladder[line], numSteps));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private StringBuilder getStringLine(boolean[] line, int numSteps) {
        StringBuilder strLine = new StringBuilder("  " + SIDE_RAIL);
        for (int step = 0; step < numSteps; ++step) {
            strLine.append(line[step] ? STEP : BLANK);
            strLine.append(SIDE_RAIL);
        }

        return strLine;
    }

}
