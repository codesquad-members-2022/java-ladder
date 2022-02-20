package application.domain.element;

public enum LadderElement {
    STEP("-----"),
    EMPTY("     "),
    RAIL("|");

    private String str;

    public String output() {
        return str;
    }

    LadderElement(String str) {
        this.str = str;
    }
}
