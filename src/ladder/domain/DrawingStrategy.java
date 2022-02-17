package ladder.domain;

import ladder.domain.ladder.LadderLine;
import ladder.utils.Count;

@FunctionalInterface
public interface DrawingStrategy {
    LadderLine executeHolizontalStrategy(Count count);
}
