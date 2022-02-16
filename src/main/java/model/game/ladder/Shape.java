package model.game.ladder;

import model.game.ladder.element.Element;

import java.util.ArrayList;
import java.util.List;

public class Shape<T extends Element> {
    private List<List<T>> shape;
    private int height;
    private int width;

    public Shape(int height, int width) {
        this.shape = new ArrayList<>();
        for (int h = 0; h < height; ++h) {
            this.shape.add(new ArrayList<>());
        }
        this.height = height;
        this.width = width;
    }

    public void addElement(int row, T element) {
        if (row >= height) {
            throw new IllegalArgumentException(
                    String.format("인덱스 범위를 초과했습니다. (최대 row %d)", height - 1));
        }
        if (getSize(row) >= width) {
            throw new IllegalArgumentException(
                    String.format("인덱스 범위를 초과했습니다. (" + row + " 번 째 열의 최대 col %d)", width - 1));
        }
        shape.get(row).add(element);
    }
    private int getSize(int row) {
        return shape.get(row).size();
    }

    public T getElement(int row, int col) {
        return shape.get(row).get(col);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
