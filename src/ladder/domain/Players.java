package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    public static final int NAME_LENGTH_LIMIT = 5;
    private static final String NAME_FORMAT = String.format("%%-%1$d.%1$ds", NAME_LENGTH_LIMIT);
    private final List<String> playerList;

    public Players(String[] playerNames) {
        this.playerList = buildPlayerList(playerNames);
    }

    public int count() {
        return playerList.size();
    }

    @Override
    public String toString() {
        return playerList.stream()
                .map(s -> "*" + s + " ")
                .collect(Collectors.joining());
    }

    private List<String> buildPlayerList (String[] playerNames) {
        return Stream.of(playerNames)
                .map(this::truncate)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private String truncate(String name) {
        return String.format(NAME_FORMAT, name);
    }
}
