package controller;

import domain.Ladder;
import domain.LadderSize;
import domain.Line;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {

    public void run(){
        while(true) {
            String[] inputNames;
            try {
                inputNames = InputView.requestPerson();
                int inputHeight = InputView.requestHeight();

                LadderSize ladderSize = LadderSize.create(inputHeight, inputNames.length);
                List<Line> lines = new Ladder(ladderSize).getLines();

                OutputView.showLadder(lines, inputNames);
                return;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
