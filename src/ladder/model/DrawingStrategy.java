package ladder.model;

import ladder.model.ladder.LadderLine;

@FunctionalInterface
public interface DrawingStrategy {
    LadderLine executeHolizontalStrategy(Count count);
}
