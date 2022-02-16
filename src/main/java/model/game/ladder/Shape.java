package model.game.ladder;

import message.ShapeMessage;
import model.game.ladder.element.Element;
import model.game.ladder.element.Line;
import model.game.ladder.element.None;
import model.game.ladder.element.Pole;

import java.util.ArrayList;
import java.util.List;

public class Shape<T extends Element> {
    Line line;
    None none;
    Pole pole;

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
        this.line = new Line(5);
        this.none = new None(5);
        this.pole = new Pole();
    }

    public void addElement(int row, T element) {
        if (row >= height) {
            throw new IllegalArgumentException(ShapeMessage.getRowIndexErrMsg(height));
        }
        if (getSize(row) >= width) {
            throw new IllegalArgumentException(ShapeMessage.getColIndexErrMsg(row, width));
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
