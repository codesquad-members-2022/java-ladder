package model;

import static java.lang.Math.*;

public class Ladder {
    private final int height;
    private final int width;
    private final Element[][] shape;

    private enum Element {
        BLANK(' '), LINE('-'), POLE('|');

        private final char ch;

        Element(char ch) {
            this.ch = ch;
        }
    }

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        this.shape = new Element[height][width];
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
    private Element allocElement() {
        return random() * 10 < 5.5 ? Element.LINE : Element.BLANK;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int h = 0; h < height; ++h) {
            appendRow(sb, h);
        }
        return sb.toString();
    }
    private void appendRow(StringBuilder sb, int h) {
        for (int w = 0; w < width; ++w) {
            sb.append(Element.POLE.ch).append(w < width - 1 ? shape[h][w].ch : "");
        }
        sb.append('\n');
    }
}
