package domain;

import java.util.List;

public class LadderRow {

    private static final String HEIGHT = "|";
    private static final String WIDTH = "-----";
    private static final String VOID = "     ";
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int DEFAULT_VOID_SIZE = 2;
    private boolean forwardVoid = true;
    private final int peopleCount;

    private final List<String> row;

    public LadderRow(List<String> row, int count) {
        this.row = row;
        this.peopleCount = count;
        init();
    }

    public void init() {
        row.add(voidBuilder());
        row.add(HEIGHT);
        makeRow();
    }

    private String voidBuilder() {
        return " ".repeat(DEFAULT_VOID_SIZE);
    }

    private void makeRow() {
        for (int i = 0; i < peopleCount - 1; i++) {
            putRandomLine();
            row.add(HEIGHT);
        }
    }

    private void putRandomLine() {
        if (putLine() && forwardVoid) {
            forwardVoid = false;
            row.add(WIDTH);
            return;
        }
        forwardVoid = true;
        row.add(VOID);
    }

    private boolean putLine() {
        return makeRandomValue() > (MAX_RANDOM_NUMBER / 2);
    }

    private int makeRandomValue() {
        return (int)(Math.random() * MAX_RANDOM_NUMBER + 1);
    }

    public List<String> getRow() {
        return row;
    }
}
