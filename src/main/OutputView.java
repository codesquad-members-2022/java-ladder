package main;

import java.util.List;
import main.util.StringUtil;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGame(LadderGame ladderGame) {
        System.out.println(Message.OUTPUT_VIEW_RESULT.get());
        printNames(ladderGame.getNames());

        for (LadderElement[] chars : ladderGame.getMap()) {
            printLine(chars);
        }
    }

    public void printNames(List<String> names) {
        for (String name : names) {
            System.out.print(StringUtil.wrapName(name) + ' ');
        }
        System.out.println();
    }

    private void printLine(LadderElement[] chars) {
        int margin = LadderElement.getGap() / 2;
        String blanks = " ".repeat(margin);

        System.out.print(blanks);
        for (LadderElement chr : chars) {
            System.out.print(chr.get());
        }
        System.out.println(blanks);
    }

}
