package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(scanner, outputView);

        LadderGame ladderGame = new LadderGame(
            inputView.getNumPerson(),
            inputView.getNumLadder()
        );
        ladderGame.createMap();

        outputView.printGame(ladderGame);
        inputView.closeScanner();
    }

}
