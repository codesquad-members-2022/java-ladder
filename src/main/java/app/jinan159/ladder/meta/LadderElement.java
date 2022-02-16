package app.jinan159.ladder.meta;

public enum LadderElement {

    L_PAD("    "),
    V_LINE("|"),
    H_LINE("-----"),
    EMPTY("     ");

    LadderElement(String mark) {
        this.mark = mark;
    }

    private final String mark;

    public String getMark() {
        return mark;
    }

}
