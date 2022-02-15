package main;

public enum LadderChar {
    VERTICAL('|'),
    HORIZONTAL('-'),
    SPACE(' ');

    private final char chr;

    LadderChar(char chr) {
        this.chr = chr;
    }

    public char get() {
        return chr;
    }
}
