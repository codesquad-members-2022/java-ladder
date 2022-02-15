package app.jinan159.ladder.meta;

public enum Elements {

    V_LINE("|"),
    H_LINE("-"),
    EMPTY(" ");

    Elements(String mark) {
        this.mark = mark;
    }

    private final String mark;

    public String getMark() {
        return mark;
    }

}
