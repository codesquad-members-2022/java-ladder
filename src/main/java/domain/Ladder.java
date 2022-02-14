package domain;

public class Ladder {

    private int playersCount;
    private int maxLadderHeight;
    private String[][] ladder;

    public Ladder(int playersCount, int maxLadderHeight) {
        this.playersCount = playersCount;
        this.maxLadderHeight = maxLadderHeight;
        ladder = new String[this.maxLadderHeight][(2 * this.playersCount) - 1];
    }
}
