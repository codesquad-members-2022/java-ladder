package Ladder.view;

import Ladder.domain.Ladder;

import java.util.List;

public class OutputView {

    public static void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

    public static void printPlayersName(List<String> playersNameList) {
        for (String playerName : playersNameList) {
            System.out.printf("%-5s ", playerName);
        }
        System.out.println();
    }
}
