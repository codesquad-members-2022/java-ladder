package ladder.domain;

public enum Element {

    LADDER_UNIT("|"),
    LINE_UNIT("-----"),
    BLANK("     "),
    LADDER_PADDING("    ");

    private final String element;

    public String getElement() {
        return element;
    }

    Element(String element) {
        this.element = element;
    }
}
