package domain;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, int height) {
        this.players = players;
        this.ladder = new Ladder(players.getPlayersCount(), height);
    }


}
