package main;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGame(LadderGame ladderGame) {
        System.out.println("\n----------\n");

        for (LadderChar[] chars : ladderGame.getMap()) {
            for (LadderChar chr : chars) {
                System.out.print(chr.getChr());
            }
            System.out.println();
        }
    }

}
