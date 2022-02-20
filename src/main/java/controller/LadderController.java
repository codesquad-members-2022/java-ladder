package controller;

import domain.LadderFactory;
import domain.ladder.Ladder;
import domain.ladder.RandomLadder;
import domain.Line;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {

    public void run() {
        while(true) {
            String[] inputNames;
            try {
                inputNames = InputView.requestPerson();
                String[] results = InputView.requestResult();
                int inputHeight = InputView.requestHeight();

                Ladder ladder = LadderFactory.makeRandomLadder(inputHeight, inputNames.length);

                OutputView.showLadder(ladder, inputNames, results);
                return;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
