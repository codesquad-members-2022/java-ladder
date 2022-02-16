package main;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGame(LadderGame ladderGame) {
        System.out.println(Message.OUTPUT_HORIZONTAL_LINE.get());

        for (LadderChar[] chars : ladderGame.getMap()) {
            printLine(chars);
        }
    }

    private void printLine(LadderChar[] chars) {
        for (LadderChar chr : chars) {
            System.out.print(chr.get());
        }
        System.out.println();
    }

}
