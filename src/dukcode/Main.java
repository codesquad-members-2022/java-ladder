package dukcode;

import dukcode.controller.LadderController;
import dukcode.model.Ladder;
import dukcode.view.PrintView;
import dukcode.view.ScanView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ScanView scanView = new ScanView(sc);
        Ladder ladder = new Ladder();
        PrintView printView = new PrintView(ladder);
        LadderController ladderController = new LadderController(printView, ladder);

        ladderController.initLadder(scanView.getPlayerName(), scanView.getHeight());
        ladderController.updatePrintView();
        sc.close();
    }
}
