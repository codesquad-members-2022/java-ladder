package model;

public enum LadderUnit {
    RAIL("|"),
    STEP("-----"),
    SPACE("     ");

    private final String ladderUnit;

    LadderUnit(String ladderUnit) {
        this.ladderUnit = ladderUnit;
    }

    public String getLadderUnit() {
        return ladderUnit;
    }
}
