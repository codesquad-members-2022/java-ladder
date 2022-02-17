package study;

import java.util.Objects;

public class Point {

    private final int x;
    private final int y;

    private Point(int x, int y) {
        if (x < 0 || x > 24) {
            throw new IllegalArgumentException();
        }
        this.x = x;

        if (y < 0 || y > 24) {
            throw new IllegalArgumentException();
        }
        this.y = y;
    }

    public static Point of(int x, int y) {
        return new Point(x, y);
    }

    public static Point ofCommaSeparator(String text) {
        String[] values = text.split(",");
        return new Point(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
