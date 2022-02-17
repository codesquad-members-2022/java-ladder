package domain.game;

import domain.ladder.Ladder;

import java.util.List;

public interface LadderGameMapDecorator {

    String drawLadderGameMap(List<String> userNames, Ladder ladder);

}
