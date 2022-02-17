package Ladder.domain;

import Ladder.util.RandomUtils;
import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final String BLANK_FOR_PRINT = "  ";
    private List<Element> elements;

    public void createLine(int playerCount) {
        initElementList();
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
            return elements.get(index - 1).getHasStep();
        }
        return elements.get(index - 2).getHasStep();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(BLANK_FOR_PRINT);
        for (Element element : elements) {
            sb.append(element.toString());
        }

        return sb.toString();
    }

    private void initElementList() {
        elements = new ArrayList<>();
    }

    private int getWidth(int playerCount) {
        return (2 * playerCount) - 1;
    }
}
