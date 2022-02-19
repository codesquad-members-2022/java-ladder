package domain.ladder;

public enum LadderElement {

    VERTICAL_LINE("|"),
    HORIZONTAL_LINE("-----"),
    EMPTY_LINE("     ");

    private String symbol;

    LadderElement(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
