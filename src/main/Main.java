package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(scanner, outputView);

        LadderMap ladderMap = new LadderMap(
            inputView.getNumPerson(),
            inputView.getNumLadder()
        );

        System.out.println(ladderMap);
    }

}
