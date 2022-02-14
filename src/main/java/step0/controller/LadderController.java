package step0.controller;

import step0.view.InputView;
import step0.view.OutputView;

import java.util.List;
import java.util.Random;

public class LadderController {

    public void run() {
        List<Integer> playerArguments = InputView.requestInfo();
        char[][] ladder = makeLadder(playerArguments.get(0), playerArguments.get(1));
        OutputView.showLadder(ladder);
    }

    private char[][] makeLadder(int personNumber, int height) {
        char[][] ladder = new char[height][personNumber+2];
        fillHeightLine(ladder);
        fillLadder(ladder);
        return ladder;
    }

    private void fillLadder(char[][] ladder) {
        Random random = new Random();
        for(int i = 0; i < ladder.length; i++){
            for(int j = 1; j < ladder[1].length; j += 2){
                if(random.nextInt(10) < 4){
                    ladder[i][j] = '-';
                    continue;
                }
                ladder[i][j] = ' ';
            }
        }
    }

    private void fillHeightLine(char[][] ladder) {
        for(int i = 0; i < ladder.length; i++){
            for(int j = 0; j < ladder[1].length; j += 2){
                ladder[i][j] = '|';
            }
        }
    }
}
