package app.jinan159.ladder.domain;

import app.jinan159.ladder.config.LadderGameConfig;

public enum LadderElement {

    L_PAD(" ".repeat(LadderGameConfig.LADDER_SIZE / 2)),
    V_LINE("|"),
    H_LINE("-".repeat(LadderGameConfig.LADDER_SIZE)),
    EMPTY(" ".repeat(LadderGameConfig.LADDER_SIZE));

    LadderElement(String mark) {
        this.mark = mark;
    }

    private final String mark;

    public String getMark() {
        return mark;
    }

}
