package view.output;

import domain.ladder.Ladder;
import domain.ladder.LadderElement;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OutputViewImpl implements OutputView {

    private static final OutputViewImpl instance = new OutputViewImpl();

    private OutputViewImpl() {}

    public static OutputView getInstance() {
        return instance;
    }

    @Override
    public void printLadder(Ladder ladder) {
        String ladderString = makeLadderString(ladder);
        System.out.print(ladderString);
    }

    private String makeLadderString(Ladder ladder) {
        return IntStream.range(0, ladder.height())
                .mapToObj(row -> makeLadderRowString(ladder, row))
                .collect(Collectors.joining("\n"));
    }

    private String makeLadderRowString(Ladder ladder, int row) {
        return IntStream.range(0, ladder.width())
                .mapToObj(column -> ladder.getLadderElement(column, row))
                .map(LadderElement::getSymbol)
                .collect(Collectors.joining());
    }

}
