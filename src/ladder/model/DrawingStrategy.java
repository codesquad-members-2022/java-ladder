package ladder.model;

@FunctionalInterface
public interface DrawingStrategy {
    LadderLine drawLine(int count);
}
