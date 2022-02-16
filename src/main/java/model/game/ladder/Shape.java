package model.game.ladder;

import message.ShapeMessage;
import model.game.ladder.element.Line;
import model.game.ladder.element.None;
import model.game.ladder.element.Pole;

import java.util.ArrayList;
import java.util.List;

import static message.ShapeMessage.*;

public class Shape<T> {
    Line line;
    None none;
    Pole pole;

    private List<List<T>> shape;
    private int height;
    private int width;

    public Shape(int height, int width, int elementSize) {
        this.shape = new ArrayList<>();
        for (int h = 0; h < height; ++h) {
            this.shape.add(new ArrayList<>());
        }
        this.height = height;
        this.width = width;
        this.line = new Line(elementSize);
        this.none = new None(elementSize);
        this.pole = new Pole();
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
        return shape.get(row).get(col);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
