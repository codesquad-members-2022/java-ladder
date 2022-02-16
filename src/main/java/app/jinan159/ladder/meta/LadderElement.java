package app.jinan159.ladder.meta;

import app.jinan159.ladder.LadderGame;

public enum LadderElement {

    L_PAD(" ".repeat(LadderGame.MAX_NAME_LENGTH / 2)),
    V_LINE("|"),
    H_LINE("-".repeat(LadderGame.MAX_NAME_LENGTH)),
    EMPTY(" ".repeat(LadderGame.MAX_NAME_LENGTH));

    LadderElement(String mark) {
        this.mark = mark;
    }

    private final String mark;

    public String getMark() {
        return mark;
    }

}
