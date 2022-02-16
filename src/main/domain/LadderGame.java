package main.domain;

import java.util.Arrays;
import java.util.List;

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

    private String wrapName(String name) {
        int gap = LadderElement.getGap();
        int margin = gap / 2 - name.length() / 2;

        char[] wrap = new char[gap];
        Arrays.fill(wrap, ' ');

        for (int ind = 0; ind < name.length(); ind++) {
            wrap[ind + margin] = name.charAt(ind);
        }
        return new String(wrap);
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
