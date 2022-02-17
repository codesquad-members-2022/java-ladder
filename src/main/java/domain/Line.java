package domain;

import java.util.List;

public class Line {
    private final List<Boolean> list;
    private final int count;
    private boolean forwardVoid = true;

    public Line(List<Boolean> list, int count) {
        this.list = list;
        this.count = count - 1;
        makeLine();
    }

    private void makeLine() {
        for (int i = 0; i < count; i++) {
            makeRandomLine();
        }
    }

    private void makeRandomLine() {
        if (forwardVoid && RandomUtil.nextBoolean()) {
            list.add(true);
            forwardVoid = false;
            return;
        }
        list.add(false);
        forwardVoid = true;
    }

    public boolean putLine(int idx) {
        return list.get(idx);
    }
}
