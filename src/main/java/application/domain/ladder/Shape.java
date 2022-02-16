package application.domain.ladder;

import java.util.ArrayList;
import java.util.List;

import static application.message.ShapeMessage.*;

public class Shape<T> {
    private final List<List<T>> shape;
    private final int height;
    private final int width;

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
            throw new IllegalArgumentException(getRowIndexErrMsg(height));
        }
        if (getSize(row) >= width) {
            throw new IllegalArgumentException(getColIndexErrMsg(row, width));
        }
        shape.get(row).add(element);
    }
    private int getSize(int row) {
        return shape.get(row).size();
    }

    public T getElement(int row, int col) {
        if (!boundaryCheck(row, col)) {
            throw new IllegalArgumentException(getBoundaryErrMsg(row, col));
        }
        return shape.get(row).get(col);
    }
    private boolean boundaryCheck(int row, int col) {
        return row >= 0 || row < height || col >= 0 || col < width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
