package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<String> line;

    private static final String LADDER_UNIT = "|";
    private static final String LINE_UNIT = "-----";
    private static final String BLANK = "     ";
    private static final String LADDER_PADDING = "    ";
    private static boolean isCreated = true;

    public Line(int countOfPlayer) {
        this.line = createLadderLine(countOfPlayer);
    }

    private List<String> createLadderLine(int countOfPlayer) {
        line = new ArrayList<>();

        int width = countOfPlayer * 2 - 1;
        line.add(LADDER_PADDING);
        for (int col = 0; col < width; col++) {
            createUnit(col, line);
        }
        return line;
    }

    private void createUnit(int col, List<String> line) {
        if (col % 2 == 1) {
            createRandomLine(line);
            return ;
        }
        line.add(LADDER_UNIT);
    }

    private void createRandomLine(List<String> line) {
        Random rand = new Random();

        if (rand.nextBoolean() && isCreated) {
            line.add(LINE_UNIT);
            isCreated = false;
            return ;
        }
        line.add(BLANK);
        isCreated = true;
    }

    public List<String> getLine() {
        return line;
    }
}
