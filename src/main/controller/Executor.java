package main.controller;

import java.util.Arrays;
import java.util.List;
import main.domain.Game;
import main.view.InputValidator;
import main.view.InputView;
import main.view.OutputView;

public class Executor {

    public void run() {
        OutputView.printParticipantsNameQueryText();
        String names = InputView.giveString();

        OutputView.printMaxHeightOfLadderQueryText();
        int maxHeightOfLadder = InputView.giveInt();

        validateInput(names,maxHeightOfLadder);

        Game game = new Game(names,maxHeightOfLadder);

        InputView.close();
    }

    public void validateInput(String string, int num) {
        validateNames(string);
        validateMaxHeightOfLadder(num);
    }

    public void validateNames(String string) {
        List<String> list = Arrays.asList(string.split(","));
        InputValidator.checkNumOfName(list);
        for (String name : list) {
            InputValidator.checkName(name);
        }
    }

    public void validateMaxHeightOfLadder(int num) {
        InputValidator.checkPositiveInt(num);
    }
}
