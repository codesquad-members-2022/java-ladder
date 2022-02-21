package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> list = new ArrayList<>();
    private boolean forwardVoid = true;

    public void addLine(boolean nextBoolean) {
        if (forwardVoid && nextBoolean) {
            list.add(true);
            forwardVoid = false;
            return;
        }
        list.add(false);
        forwardVoid = true;
    }

    public boolean canPutLine(int idx) {
        return list.get(idx);
    }
}
