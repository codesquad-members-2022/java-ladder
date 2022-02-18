package ladder.domain;

public class LadderGameInfo {
    private final int countOfPlayer;
    private final int height;
    private final String[] playerNames;
    private final String[] results;

    public LadderGameInfo(int countOfPlayer, int height, String[] playerNames, String[] results) {
        this.countOfPlayer = countOfPlayer;
        this.height = height;
        this.playerNames = playerNames;
        this.results = results;
    }

    public int getCountOfPlayer() {
        return countOfPlayer;
    }

    public int getHeight() {
        return height;
    }

    public String[] getPlayerNames() {
        return playerNames;
    }

    public String[] getResults() {
        return results;
    }
}
