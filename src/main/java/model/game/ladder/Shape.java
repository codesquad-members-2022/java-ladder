package model.game.ladder;

import message.LadderMessage;
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
            throw new IllegalArgumentException(LadderMessage.getRowIndexErrMsg(height));
        }
        if (getSize(row) >= width) {
            throw new IllegalArgumentException(LadderMessage.getColIndexErrMsg(row, width));
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
