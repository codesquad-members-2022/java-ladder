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

        for (List<LadderElement> elements : ladderGame.getMap()) {
            printLine(elements);
        }
    }

    public void printNames(List<String> names) {
        StringBuilder sb = new StringBuilder();

        for (String name : names) {
            sb.append(StringUtil.wrapName(name)).append(' ');
        }
        System.out.println(sb);
    }

    private void printLine(List<LadderElement> elements) {
        String blanks = " ".repeat(LadderElement.getGap() / 2);
        StringBuilder sb = new StringBuilder();

        sb.append(blanks);
        for (LadderElement element : elements) {
            sb.append(element.get());
        }
        sb.append(blanks);

        System.out.println(sb);
    }

}
