package domain.ladder;

public enum LadderElement {

    VERTICAL_LINE('|'),
    HORIZONTAL_LINE('-'),
    EMPTY_LINE(' ');

    private char symbol;

    LadderElement(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }
}
