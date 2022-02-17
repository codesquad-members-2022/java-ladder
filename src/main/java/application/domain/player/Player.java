package application.domain.player;

import application.domain.ladder.Ladder;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        if (name.length() > Ladder.INTERVAL) {
            name = name.substring(0, Ladder.INTERVAL - 2).concat("..");
        }
        return String.format("%-5s", name.concat(" "));
    }
}

