package model.game.ladder;

import model.game.ladder.element.Element;

import static java.lang.Math.*;

public class Ladder {
    private final Shape shape;
    private final int height;
    private final int width;

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        this.shape = new Shape(height, width);
        createLine();
    }

    private void createLine() {
        int height = shape.getHeight();
        for (int h = 0; h < height; ++h) {
            createLine(h);
        }
    }
    private void createLine(int h) {
        int width = shape.getWidth();
        for (int w = 0; w < width; ++w) {
            shape.addElement(h, allocElement());
        }
    }
    private Element allocElement() {
        return random() * 10 < 5.5 ? shape.line : shape.none;
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
            sb.append(shape.pole).append(w < width - 1 ? shape.getElement(h, w) : "");
        }
        sb.append('\n');
    }
}
