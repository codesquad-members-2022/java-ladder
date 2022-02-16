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

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
