package domain.ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderRow {

    private final List<LadderElement> ladderElements;

    LadderRow(int width) {
        ladderElements = initLadderRow(width);
    }

    private List<LadderElement> initLadderRow(int width) {
        return IntStream.range(0, width)
                .mapToObj(column -> LadderElement.EMPTY_LINE)
                .collect(Collectors.toList());
    }

    public LadderElement getLadderElement(int column) {
        return ladderElements.get(column);
    }

    public void drawLadderElement(int column, LadderElement ladderElement) {
        ladderElements.set(column, ladderElement);
    }

    public int width() {
        return ladderElements.size();
    }
}
