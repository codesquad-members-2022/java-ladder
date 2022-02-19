package main.domain;

import java.util.List;

public class Player {

    private final String name;
    private String outcome;

    private int row;
    private int col;

    public Player(String name, int ind) {
        this.name = name;
        this.row = 0;
        this.col = ind * 2;
    }

    public String getName() {
        return name;
    }

    public String getOutcome() {
        return outcome;
    }

    public int row() {
        return row;
    }

    public void moveAlong(List<LadderElement> elements) {
        moveDown();

        if (checkLeft(elements)) {
            moveLeft();
            return;
        }
        if (checkRight(elements)) {
            moveRight();
        }
    }

    public void receive(List<String> outcomes) {
        outcome = outcomes.get(col / 2);
    }

    public boolean checkLeft(List<LadderElement> elements) {
        return isLeftIn() && isHorizontal(getLeft(elements));
    }

    public boolean checkRight(List<LadderElement> elements) {
        int width = elements.size();
        return isRightIn(width) && isHorizontal(getRight(elements));
    }

    public boolean isLeftIn() {
        return col - 2 >= 0;
    }

    public boolean isRightIn(int width) {
        return col + 2 <= (width - 1);
    }

    public boolean isHorizontal(LadderElement element) {
        return element == LadderElement.HORIZONTAL;
    }

    public LadderElement getLeft(List<LadderElement> elements) {
        return elements.get(col - 1);
    }

    public LadderElement getRight(List<LadderElement> elements) {
        return elements.get(col + 1);
    }

    public void moveLeft() {
        col -= 2;
    }

    public void moveRight() {
        col += 2;
    }

    public void moveDown() {
        row += 1;
    }

}
