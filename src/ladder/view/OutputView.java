package ladder.view;

import ladder.model.Name;
import ladder.model.Names;
import ladder.model.ladder.LadderLines;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String NAME_SPACE = "     ";

    private OutputView() {
    }

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        if (instance == null) {
            return new OutputView();
        }
        return instance;
    }

    public void print(LadderLines ladderLines, Names names) {
        printNames(names);
        printLadder(ladderLines);
    }

    private void printLadder(LadderLines ladderLines) {

    }

    private static void printNames(Names names) {
        String result = names.getElements().stream()
                .map(Name::getName)
                .collect(Collectors.joining(NAME_SPACE));
        print(result);
    }

    private static void print(String result) {
        System.out.println(result);
    }
}
