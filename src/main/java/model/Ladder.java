package model;

import static java.lang.Math.*;

public class Ladder {
    private final int height;
    private final int width;
    private final char[][] shape;

    private enum Mark {
        BLANK(' '), LINE('-'), POLE('|');

        private final char ch;

        Mark(char ch) {
            this.ch = ch;
        }
    }

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        this.shape = new char[height][width];
        initShape();
    }

    private void initShape() {
        for (int h = 0; h < height; ++h) {
            assignLine(h);
        }
    }
    private void assignLine(int h) {
        for (int w = 0; w < width; ++w) {
            shape[h][w] = allocElement();
        }
    }
    private char allocElement() {
        return random() * 10 < 5.5 ? Mark.LINE.ch : Mark.BLANK.ch;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int h = 0; h < height; ++h) {
            appendRow(sb, h);
            sb.append('\n');
        }
        return sb.toString();
    }
    private void appendRow(StringBuffer sb, int h) {
        for (int w = 0; w < width; ++w) {
            sb.append(Mark.POLE.ch).append(w < width - 1 ? shape[h][w] : "");
        }
    }
}
