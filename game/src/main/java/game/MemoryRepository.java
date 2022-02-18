package game;

import java.util.List;

public interface MemoryRepository {
    void save(GameInfo gameInfo);

    int findPlayerNumber();

    int findHeight();

    List<String> findPlayerNames();
}
