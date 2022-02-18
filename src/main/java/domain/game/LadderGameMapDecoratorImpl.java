package domain.game;

import domain.ladder.Ladder;
import domain.ladder.LadderElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameMapDecoratorImpl implements LadderGameMapDecorator {

    private static final int NAME_FORMAT_LIMIT = 5;

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

    public String formatUserName(String userName) {
        userName = cutUserName(userName);
        return String.format("%6s", userName);
    }

    public String cutUserName(String userName) {
        if (userName.length() > NAME_FORMAT_LIMIT) {
            return userName.substring(0,NAME_FORMAT_LIMIT)
                    .replaceAll("(?<=.{3}).",".");
        }
        return userName;
    }

    private String ladderRowString(Ladder ladder, int row) {
        return IntStream.range(0, ladder.width())
                .mapToObj(column -> ladder.getLadderElement(column, row))
                .map(LadderElement::getSymbol)
                .collect(Collectors.joining("","    ",""));
    }
}
