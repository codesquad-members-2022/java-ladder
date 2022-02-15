package model;

import java.util.stream.IntStream;
import static java.util.Arrays.*;

public class Ladder {
    private int height;
    private int width;
    private char[][] shape;

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        this.shape = new char[height][width];
        initShape();
    }

    private char[][] initShape() {
        for (int h = 0; h < height; ++h) {
            fill(shape[h], ' ');
        }
        assignLine();
        return shape;
    }
    private void assignLine() {
        for (int h = 0; h < height; ++h) {
            assignLine(h);
        }
    }
    private void assignLine(int h) {
        for (int w = 0; w < width; ++w) {
            shape[h][w] = isLine(h, w) ? '-' : ' ';
        this.shape = initShape();
    }

    private char[][] initShape() {
        char[][] shape = new char[height][width];
        for (int h = 0; h < height; ++h) {
            fill(shape[h], ' ');
        }
        assignLine(shape);
        return shape;
    }
    private void assignLine(char[][] shape) {
        for (int h = 0; h < height; ++h) {
            for (int w = 0; w < width; ++w) {
                if (isLine(h, w)) {
                    shape[h][w] = '-';
                }
            }
        }
    }
    private boolean isLine(int h, int w) {
        int indexValue = (h + 1) * (w + 1) + w + 1;
        int randomValue = (int) (Math.random() * height * width + 1);
        int maxValue = Math.max(indexValue, randomValue);
        return IntStream.rangeClosed(2, (int) Math.sqrt(maxValue)).filter(value ->
                (indexValue % value == 0 && randomValue % value == 0)
        ).findAny().isPresent();
        for (int value = 2; value * value <= maxValue; ++value) {
            if (indexValue % value == 0 && randomValue % value == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int h = 0; h < height; ++h) {
            appendRow(sb, h);
            for (int w = 0; w < width; ++w) {
                sb.append('|').append(w < width - 1 ? shape[h][w] : "");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
    private void appendRow(StringBuffer sb, int h) {
        for (int w = 0; w < width; ++w) {
            sb.append('|').append(w < width - 1 ? shape[h][w] : "");
        }
    }
}
