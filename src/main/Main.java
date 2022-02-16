package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import main.domain.Game;
import main.util.InputValidator;
import main.view.InputView;
import main.view.OutputView;

public class Main {

    public static void main(String[] args) {
        OutputView.printParticipantsNameQueryText();
        String names = InputView.giveString();
        List<String> namesList = Arrays.asList(names.split(","));
        InputValidator.checkNumOfName(namesList);
        for (String name : namesList) {
            InputValidator.checkName(name);
        }

        OutputView.printMaxHeightOfLadderQueryText();
        int maxHeightOfLadder = InputView.giveInt();
        InputValidator.checkPositiveInt(maxHeightOfLadder);





//        Game game = new Game();
//        game.init(numOfPeople, maxHeightOfLadder);
//
//        OutputView.printLadderBoard(game.getLadderBoard());
//
//        InputView.close();
    }
}
