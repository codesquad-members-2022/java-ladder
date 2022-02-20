package dukcode.controller;

import dukcode.ladder.Ladder;
import dukcode.view.PrintView;
import dukcode.view.ScanView;

public class LadderGameController {
    private final ScanView scanView;
    private final Ladder ladder;
    private final PrintView printView;

    public LadderGameController(ScanView scanView, PrintView printView, Ladder ladder) {
        this.scanView = scanView;
        this.printView = printView;
        this.ladder = ladder;
    }

    public void initLadder() {
        String[] namePlayers = scanView.getPlayerName();
        String[] results = scanView.getResults();
        int height = scanView.getHeight();
        ladder.init(namePlayers, results, height);
    }

    public void printGame() {
        printView.printGame();
    }

    public void playGame() {
        printGame();
        printResults();
    }

    public void printResults() {
        while(true) {
            String PlayerNameToShowResult = scanView.getPlayerNameToShowResult();

            if (PlayerNameToShowResult.equals("춘식이")) {
                printView.printExitMessage();
                return;
            }

            if (PlayerNameToShowResult.equals("all")) {
                printView.printResultOfAllPlayer();
                continue;
            }

            printView.printResultOfPlayer(PlayerNameToShowResult);
        }
    }
}
