package domain;

public enum Direction {
    RIGHT(1), LEFT(2);

    private int num;

    Direction(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}
