package ladder.model;

import ladder.model.ladder.LadderLine;

@FunctionalInterface
public interface DrawingStrategy {
    LadderLine drawLine(int count);
}
