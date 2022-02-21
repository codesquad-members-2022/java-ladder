package ladder.view;

import ladder.domain.ladder.LadderLine;
import ladder.domain.ladder.LadderLines;
import ladder.domain.ladder.Point;
import ladder.domain.user.Name;
import ladder.domain.user.Names;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String EXECUTION_RESULT = "실행 결과\n";
    private static final String EMPTY_LINE = "     ";
    private static final String COLUMN = "|";
    private static final String LADDER = "-----";
    private static final String NEXT_LINE = "\n";

    private OutputView() {}

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        if (instance == null) {
            return new OutputView();
        }
        return instance;
    }

    public void print(LadderLines ladderLines, Names names) {
        print(EXECUTION_RESULT);
        printNames(names);
        printLadder(ladderLines);
    }

    private void printLadder(LadderLines ladderLines) {
        List<LadderLine> lines = ladderLines.getLadderLines();
        StringBuilder stringBuilder = new StringBuilder();
        for (LadderLine line : lines) {
            addLine(stringBuilder, line);
            stringBuilder.append(NEXT_LINE);
        }
        print(stringBuilder.toString());
    }

    private void addLine(StringBuilder stringBuilder, LadderLine line) {
        for (Point point : line.getPoints()) {
            stringBuilder.append(COLUMN);
            if (point.getDirection().hasRight()) {
                stringBuilder.append(LADDER);
            }
            if (!point.getDirection().hasRight()) {
                stringBuilder.append(EMPTY_LINE);
            }
        }
    }

    private static void printNames(Names names) {
        String result = getNames(names);
        print(result);
    }

    private static String getNames(Names names) {
        return names.getElements().stream()
                .map(Name::getName)
                .collect(Collectors.joining(EMPTY_LINE));
    }

    private static void print(String result) {
        System.out.println(result);
    }
}
