package Ladder.domain;

public class Element {

    private static final String LADDER_VERTICAL_LINE = "|";
    private static final String LADDER_HORIZONTAL_LINE = "-----";
    private static final String LADDER_BLANK = "     ";

    private int index;
    private String value;
    private boolean hasStep;

    public Element(int index, boolean hasPrevStep, boolean rand) {
        this.index = index;
        this.value = setValue(index, hasPrevStep, rand);
        this.hasStep = false;
        if (this.value.equals(LADDER_HORIZONTAL_LINE)) {
            this.hasStep = true;
        }
    }

    private String setValue(int index, boolean hasPrevStep, boolean rand) {
        if (index % 2 == 0) {
            return LADDER_VERTICAL_LINE;
        }
        if (index % 2 != 0 && !hasPrevStep && rand) {
            return LADDER_HORIZONTAL_LINE;
        }
        return LADDER_BLANK;
    }

    public boolean getHasStep() {
        return this.hasStep;
    }
}
