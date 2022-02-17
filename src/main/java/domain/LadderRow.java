package domain;

import java.util.List;

public class LadderRow {

    private static final String HEIGHT = "|";
    private static final String WIDTH = "-";
    private static final String VOID = " ";
    private static final int DEFAULT_VOID_SIZE = 2;
    private static final int DEFAULT_WIDTH = 5;

    private final int peopleCount;
    private final List<String> row;
    private final Line line;

    public LadderRow(List<String> row, int count) {
        this.row = row;
        this.peopleCount = count;
        line = new Line(count);
        init();
    }

    public void init() {
        row.add(voidBuilder());
        row.add(HEIGHT);
        makeRow();
    }

    private String voidBuilder() {
        return VOID.repeat(DEFAULT_VOID_SIZE);
    }

    private void makeRow() {
        for (int i = 0; i < peopleCount - 1; i++) {
            putRandomLine(i);
            row.add(HEIGHT);
        }
    }

    private void putRandomLine(int idx) {
        boolean putValue = line.putLine(idx);
        if(putValue) {
            row.add(WIDTH.repeat(DEFAULT_WIDTH));
            return;
        }
        row.add(VOID.repeat(DEFAULT_WIDTH));
    }

    public List<String> getRow() {
        return row;
    }
}
