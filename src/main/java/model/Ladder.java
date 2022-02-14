package model;

import static java.util.Arrays.*;

public class Ladder {
    private int height;
    private int width;
    private char[][] shape;

    public Ladder(int height, int width) {
        this.height = height;
        this.width = width;
        this.shape = initShape();
    }

    private char[][] initShape() {
        char[][] shape = new char[height][width];
        for (int h = 0; h < height; ++h) {
            fill(shape[h], ' ');
        }
        return shape;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int h = 0; h < height; ++h) {
            for (int w = 0; w < width; ++w) {
                sb.append('|').append(w < width - 1 ? shape[h][w] : "");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
