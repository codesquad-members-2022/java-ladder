package application.domain.element;

import application.domain.ladder.Ladder;

public enum LadderElement {
    STEP("-".repeat(Ladder.INTERVAL)),
    EMPTY(" ".repeat(Ladder.INTERVAL)),
    RAIL("|");

    private final String str;

    public String output() {
        return str;
    }

    LadderElement(String str) {
        this.str = str;
    }
}
