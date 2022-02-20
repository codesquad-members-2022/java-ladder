package app.jinan159.ladder.domain.gamemap;

import app.jinan159.ladder.domain.LadderElement;

public class GameMapColumn {

    private final LadderElement element;

    public GameMapColumn(LadderElement element) {
        this.element = element;
    }

    public LadderElement getElement() {
        return element;
    }

    public char getColumnValue() {
        return element.getMark();
    }
}
