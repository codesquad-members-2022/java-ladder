package application.domain.ladder;

import application.domain.ladder.element.Element;
import application.domain.ladder.element.Line;
import application.domain.ladder.element.None;
import application.domain.ladder.element.Pole;

import static application.util.RandomUtils.nextDouble;

public class Ladder {
    private final Shape<Element> shape;
    private final Line line;
    private final None none;
    private final Pole pole;

    private final int height;
    private final int width;

    public Ladder(int height, int width, int maxNameLength) {
        this.height = height;
        this.width = width;
        this.shape = new Shape<>(height, width);
        this.line = new Line(maxNameLength);
        this.none = new None(maxNameLength);
        this.pole = new Pole();
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
            try {
                shape.addElement(h, allocElement(h, w));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private Element allocElement(int h, int w) {
        return nextDouble() * 10 < 5.5 && isValid(h, w) ? line : none;
    }
    private boolean isValid(int h, int w) {
        return w == 0 || (shape.getElement(h, w - 1) != line);
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
            sb.append(pole).append(getOutput(shape, h, w));
        }
        sb.append('\n');
    }

    private String getOutput(Shape<Element> shape, int h, int w) {
        return w < width - 1 ? shape.getElement(h, w).toString() : "";
    }
}
