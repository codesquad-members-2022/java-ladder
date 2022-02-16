package main.model;

public class Game {

    private int numOfPeople;
    private int maxHeightOfLadder;

    private Ladder ladder;

    public void init(int numOfPeople, int maxHeightOfLadder) {
        this.numOfPeople = numOfPeople;
        this.maxHeightOfLadder = maxHeightOfLadder;
        ladder = new Ladder(numOfPeople, maxHeightOfLadder);
    }

    public String[][] returnLadderBoard() {
        return ladder.returnBoard();
    }

}
