package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Element> line;
    private static boolean isCreated = true;

    public Line(int countOfPlayer) {
        this.line = createLadderLine(countOfPlayer);
    }

    private List<Element> createLadderLine(int countOfPlayer) {
        line = new ArrayList<>();

        int width = countOfPlayer * 2 - 1;
        line.add(Element.LADDER_PADDING);
        for (int col = 0; col < width; col++) {
            createUnit(col, line);
        }
        return line;
    }

    private void createUnit(int col, List<Element> line) {
        if (col % 2 == 1) {
            createRandomLine(line);
            return ;
        }
        line.add(Element.LADDER_UNIT);
    }

    private void createRandomLine(List<Element> line) {
        Random rand = new Random();

        if (rand.nextBoolean() && isCreated) {
            line.add(Element.LINE_UNIT);
            isCreated = false;
            return ;
        }
        line.add(Element.BLANK);
        isCreated = true;
    }

    public List<Element> getLine() {
        return line;
    }
}
