package dukcode;

import dukcode.controller.LadderGameController;
import dukcode.ladder.Ladder;
import dukcode.ladder.view.LadderView;
import dukcode.view.PrintView;
import dukcode.view.ScanView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ScanView scanView = new ScanView(sc);
        Ladder ladder = new Ladder();
        LadderView ladderView = new LadderView(ladder);
        PrintView printView = new PrintView(ladderView);
        LadderGameController ladderGameController = new LadderGameController(printView, ladder);

        ladderGameController.initLadder(scanView.getPlayerName(),scanView.getResults(), scanView.getHeight());
        ladderGameController.updatePrintView();
        sc.close();
    }
}
