package app.jinan159.ladder.domain;

public enum LadderElement {

    L_PAD(' '),
    V_LINE('|'),
    H_LINE('-'),
    EMPTY(' ');

    LadderElement(char mark) {
        this.mark = mark;
    }

    private final char mark;

    public char getMark() {
        return mark;
    }

}
