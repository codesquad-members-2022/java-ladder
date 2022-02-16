package main.domain;

import java.util.ArrayList;
import java.util.List;
import main.util.RandomUtil;

public class LadderLine {

    private final int length;
    private final List<LadderElement> elements;

    public LadderLine(int length) {
        this.length = length;
        this.elements = new ArrayList<>();

        addAll();
    }

    private void addAll() {
        boolean next = true;

        for (int ind = 0; ind < length; ind++) {
            LadderElement element = add(ind, next, RandomUtil.nextBoolean());
            next = element.getNext(next);
        }
    }

    private LadderElement add(int ind, boolean next, boolean rand) {
        LadderElement ladderElement = LadderOperation.create(ind, next, rand);
        elements.add(ladderElement);

        return ladderElement;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String blanks = " ".repeat(LadderElement.getGap() / 2);

        sb.append(blanks);
        for (LadderElement element : elements) {
            sb.append(element.get());
        }
        sb.append(blanks).append("\n");

        return sb.toString();
    }
}
