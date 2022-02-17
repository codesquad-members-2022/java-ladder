package domain.ladder;

public interface LadderFactory {

    Ladder create(int numberOfUsers, int height);
}
