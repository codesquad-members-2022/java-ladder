package main.domain;

import java.util.Arrays;
import java.util.List;

public class Game {

    private List<String> namesList;
    private int numOfPeople;
    private int maxHeightOfLadder;

    private Ladder ladder;

    public Game(String names, int maxHeightOfLadder) {
        namesList = Arrays.asList(names.split(","));
        numOfPeople = namesList.size();

        this.maxHeightOfLadder = maxHeightOfLadder;

        ladder = new Ladder(numOfPeople, maxHeightOfLadder);
    }

    public List<HorizontalLine> getLadderBoard() {
        return ladder.getBoard();
    }

}
