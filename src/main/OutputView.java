package main;

import java.util.List;
import main.util.StringUtil;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printGame(LadderGame ladderGame) {
        printMessage(Message.OUTPUT_VIEW_RESULT.get());

        StringBuilder sb = new StringBuilder();
        appendNames(sb, ladderGame.getNames());

        for (List<LadderElement> elements : ladderGame.getMap()) {
            appendLines(sb, elements);
        }
        System.out.println(sb);
    }

    private static void appendNames(StringBuilder sb, List<String> names) {
        for (String name : names) {
            sb.append(StringUtil.wrapName(name)).append(' ');
        }
        sb.append("\n");
    }

    private static void appendLines(StringBuilder sb, List<LadderElement> elements) {
        String blanks = " ".repeat(LadderElement.getGap() / 2);

        sb.append(blanks);
        for (LadderElement element : elements) {
            sb.append(element.get());
        }
        sb.append(blanks).append("\n");
    }

}
