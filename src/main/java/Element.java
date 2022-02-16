public enum Element {
    EMPTY("     "),
    STEP("-----"),
    RAIL("|");

    private final String value;

    Element(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
