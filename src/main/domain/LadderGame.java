package main.domain;

import java.util.List;
import main.util.InputUtil;

public class LadderGame {

    private final List<String> names;
    private final int numLadder;
    private final LadderPlane plane;

    public LadderGame(List<String> names, int numLadder) {
        this.names = names;
        this.numLadder = numLadder;

        plane = new LadderPlane(getHeight(), getWidth());
    }

    private int getHeight() {
        return numLadder;
    }

    private int getWidth() {
        return 2 * names.size() - 1;
    }

    public String wrapName(String name) {
        int gap = LadderElement.getGap();

        int margin = getMargin(name, gap);
        char[] wrap = InputUtil.fillNull(gap);

        for (int ind = 0; ind < name.length(); ind++) {
            wrap[ind + margin] = name.charAt(ind);
        }
        return new String(wrap);
    }

    private int getMargin(String name, int gap) {
        int margin = gap / 2 - name.length() / 2;

        if (margin < 0) {
            throw new IllegalArgumentException();
        }
        return margin;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (String name : names) {
            sb.append(wrapName(name)).append(' ');
        }
        sb.append("\n").append(plane);

        return sb.toString();
    }
}
