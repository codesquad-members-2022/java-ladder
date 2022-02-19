package Ladder.domain;

public class Element {

    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_HORIZONTAL_LINE = "-----";
    private static final String LADDER_BLANK = "     ";

    private String value;

    public Element(int index, boolean hasPrevStep, boolean rand) {
        this.value = setValue(index, hasPrevStep, rand);
    }

    private String setValue(int index, boolean hasPrevStep, boolean rand) {
        if (index % 2 == 0) {
            return LADDER_VERTICAL_LINE;
        }
        if (!hasPrevStep && rand) {
            return LADDER_HORIZONTAL_LINE;
        }
        return LADDER_BLANK;
    }

    public boolean hasStep() {
        return this.value.contains(LADDER_HORIZONTAL_LINE);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
