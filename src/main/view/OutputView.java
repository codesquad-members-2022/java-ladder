package main.view;

import java.util.List;
import main.domain.LadderElement;
import main.domain.LadderGame;
import main.util.StringUtil;

public class OutputView {

    private static final String EXECUTE_RESULT = "\n실행결과\n";
    private static final String ILLEGAL_INPUT = "\n이름은 최대 5글자까지만 입력 가능합니다.";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printGame(LadderGame ladderGame) {
        printMessage(EXECUTE_RESULT);

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

    public static void printIllegalException() {
        printMessage(ILLEGAL_INPUT);
    }

}
