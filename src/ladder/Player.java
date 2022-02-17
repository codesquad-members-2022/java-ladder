package src.ladder;

public class Player {

    private final String name;
    private final int playerNumber;

    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }
}
