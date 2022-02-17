package domain.game;

import domain.ladder.Ladder;
import domain.ladder.LadderElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameMapDecoratorImpl implements LadderGameMapDecorator {

    private static final LadderGameMapDecoratorImpl instance = new LadderGameMapDecoratorImpl();

    private LadderGameMapDecoratorImpl() {}

    public static LadderGameMapDecoratorImpl getInstance() {
        return instance;
    }

    @Override
    public String drawLadderGameMap(List<String> userNames, Ladder ladder) {
        return String.join("\n",userNamesString(userNames), ladderString(ladder));
    }

    private String ladderString(Ladder ladder) {
        return IntStream.range(0, ladder.height())
                .mapToObj(row -> ladderRowString(ladder, row))
                .collect(Collectors.joining("\n"));
    }

    private String userNamesString(List<String> userNames) {
        return userNames.stream()
                .map(this::formatUserName)
                .collect(Collectors.joining());
    }

    private String formatUserName(String userName) {
        return String.format("%6s", userName);
    }

    private String ladderRowString(Ladder ladder, int row) {
        return IntStream.range(0, ladder.width())
                .mapToObj(column -> ladder.getLadderElement(column, row))
                .map(LadderElement::getSymbol)
                .collect(Collectors.joining());
    }
}
