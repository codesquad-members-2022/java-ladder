package main;

import java.util.Scanner;
import main.util.StringUtil;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(scanner, outputView);

        LadderGame ladderGame = new LadderGame(
            StringUtil.parseNames(inputView.getNames()),
            inputView.getNumLadder()
        );
        ladderGame.createMap();

        outputView.printGame(ladderGame);
        inputView.closeScanner();
    }

}
