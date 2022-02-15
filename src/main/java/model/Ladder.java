package model;

import java.util.stream.IntStream;

import static java.util.Arrays.*;

public class Ladder {
    private int height;
    private int width;
    private char[][] shape;

    private enum Mark {
        BLANK(' '), LINE('-'), POLE('|');

        private final char ch;

        Mark(char ch) {
            this.ch = ch;
        }

        char getCh() {
            return ch;
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
            shape[h][w] = isLine(h, w) ? Mark.LINE.ch : Mark.BLANK.ch;
        }
    }
    private boolean isLine(int h, int w) {
        int indexValue = (h + 1) * (w + 1) + w + 1;
        int randomValue = (int) (Math.random() * height * width + 1);
        int maxValue = Math.max(indexValue, randomValue);
        return IntStream.rangeClosed(2, (int) Math.sqrt(maxValue)).filter(value ->
                (indexValue % value == 0 && randomValue % value == 0)
        ).findAny().isPresent();
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
            sb.append(Mark.POLE.getCh()).append(w < width - 1 ? shape[h][w] : "");
        }
    }
}
