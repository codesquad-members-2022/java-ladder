package main.domain;

public enum LadderElement {
    VERTICAL("|"),
    HORIZONTAL("-----"),
    BLANK("     ");

    private final String str;

    LadderElement(String str) {
        this.str = str;
    }

    public static int getGap() {
        return HORIZONTAL.get().length();
    }

    public String get() {
        return str;
    }
}
