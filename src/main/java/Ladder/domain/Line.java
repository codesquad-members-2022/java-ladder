package Ladder.domain;

import Ladder.util.RandomUtils;
import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Element> elements = new ArrayList<>();;

    public void createLine(int playerCount) {
        int width = getWidth(playerCount);

        for (int i = 0; i < width; i++) {
            Element currentElement = new Element(i, isStep(i), RandomUtils.getRandomBoolean());
            elements.add(currentElement);
        }
    }

    private boolean isStep(int index) {
        if (index < 2) {
            return false;
        }
        if (index % 2 == 0) {
            return elements.get(index - 1).hasStep();
        }
        return elements.get(index - 2).hasStep();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String blankForPrint = "  ";

        sb.append(blankForPrint);
        for (Element element : elements) {
            sb.append(element.toString());
        }

        return sb.toString();
    }

    private int getWidth(int playerCount) {
        return (2 * playerCount) - 1;
    }
}
