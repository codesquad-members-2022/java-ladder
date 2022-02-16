package domain.ladder;

public interface LadderFactory {

    Ladder create(int entry, int height);
    Ladder copy(Ladder original);
}
