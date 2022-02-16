package view.output;

import domain.ladder.Ladder;
import domain.ladder.LadderElement;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputViewImpl implements OutputView {

    private static final OutputViewImpl instance = new OutputViewImpl();

    private OutputViewImpl() {}

    public static OutputView getInstance() {
        return instance;
    }

    @Override
    public void printLadder(Ladder ladder) {
        LadderElement[][] ladderElements = ladder.getLadderElements();
        String ladderString = makeLadderString(ladderElements);
        System.out.print(ladderString);
    }

    private String makeLadderString(LadderElement[][] ladderElements) {
        return Stream.of(ladderElements)
                    .map(this::makeLadderRowString)
                    .collect(Collectors.joining("\n"));
    }

    private String makeLadderRowString(LadderElement[] ladderRow) {
        return Stream.of(ladderRow)
                    .map(LadderElement::getSymbol)
                    .map(String::valueOf)
                    .collect(Collectors.joining());
    }
}
