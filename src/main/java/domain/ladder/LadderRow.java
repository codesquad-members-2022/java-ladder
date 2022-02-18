package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderRow  {

    private static final float ATTACH_HORIZONTAL_LINE_PROBABILITY = 0.5f;

    private final List<LadderElement> ladderElements = new ArrayList<>();

    LadderRow(int width) {
        initLadderRow(width);
    }

    private void initLadderRow(int width) {
        IntStream.range(0, width)
                .mapToObj(this::selectLadderElement)
                .forEach(ladderElements::add);
    }

    public LadderElement getLadderElement(int column) {
        return ladderElements.get(column);
    }

    private LadderElement selectLadderElement(int column) {
        if (isVerticalLineDrawableColumn(column)) {
            return LadderElement.VERTICAL_LINE;
        }
        if (isHorizontalLineDrawableColumn(column)) {
            return randomLadderElement();
        }
        return LadderElement.EMPTY_LINE;
    }

    private LadderElement randomLadderElement() {
        boolean attachHorizontalLine = generateRandomBool(ATTACH_HORIZONTAL_LINE_PROBABILITY);
        return (attachHorizontalLine) ? LadderElement.HORIZONTAL_LINE : LadderElement.EMPTY_LINE;
    }

    private boolean generateRandomBool(float probabilityOfTrue) {
        double randomFloat = Math.random();
        boolean randomBool = (0<= randomFloat) && (randomFloat < probabilityOfTrue);
        return randomBool;
    }

    public boolean isVerticalLineDrawableColumn(int column) {
        return (column%2 == 0);
    }

    public boolean isHorizontalLineDrawableColumn(int column) {
        if (isVerticalLineDrawableColumn(column)) {
            return false;
        }
        if (column == 1) {
            return true;
        }
        return getLadderElement(column - 2) == LadderElement.EMPTY_LINE;
    }

    public int width() {
        return ladderElements.size();
    }
}
