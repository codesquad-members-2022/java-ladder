package domain;

import util.RandomUtils;
import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Element> elements;

    public void createLine(int playerCount) {
        initElementList();
        int width = getWidth(playerCount);
        Element prevElement = null;

        for (int i = 0; i < width; i++) {
            Element currentElement = new Element(i, getPrevElementHasStep(prevElement), RandomUtils.getRandomBoolean());
            elements.add(currentElement);
            prevElement = currentElement;
        }
    }

    private boolean getPrevElementHasStep(Element prevElement) {
        if (prevElement != null) {
            return prevElement.getHasStep();
        }
        return false;
    }

    private void initElementList() {
        elements = new ArrayList<>();
    }

    private int getWidth(int playerCount) {
        return (2 * playerCount) - 1;
    }
}
