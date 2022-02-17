package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> list = new ArrayList<>();
    private final int count;
    private boolean forwardVoid = true;

    public Line(int count) {
        this.count = count - 1;
        makeLine();
    }

    private void makeLine() {
        for (int i = 0; i < count; i++) {
            makeRandomLine();
        }
    }

    private void makeRandomLine() {
        boolean result = RandomUtil.putLine(forwardVoid);
        list.add(result);
        if (result) {
            forwardVoid = false;
            return;
        }
        forwardVoid = true;
    }

    public boolean putLine(int idx) {
        return list.get(idx);
    }
}
