package ladder.view;

public enum Symbol {

    COLUMN("|"),
    LADDER("-"),
    BLANK(" ");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }
}
