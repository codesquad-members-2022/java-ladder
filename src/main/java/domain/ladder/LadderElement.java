package domain.ladder;

enum LadderElement {
    EMPTY("     "),
    STEP("-----"),
    RAIL("|");

    private final String value;

    LadderElement(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
