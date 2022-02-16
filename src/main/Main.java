package main;

import main.model.Game;
import main.view.InputView;
import main.view.OutputView;

public class Main {

    public static void main(String[] args) {
        OutputView.printNumOfPeopleQueryText();
        int numOfPeople = InputView.giveInt();

        OutputView.printMaxHeightOfLadderQueryText();
        int maxHeightOfLadder = InputView.giveInt();

        InputView.closeScanner();

        Game game = new Game();
        game.init(numOfPeople, maxHeightOfLadder);

        OutputView.printLadderBoard(game.returnLadderBoard());
    }
}
