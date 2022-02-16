package model.game.ladder.element;

public class Line implements Element {
    private String str = "-";

    public Line(int length) {
        StringBuffer sb = new StringBuffer();
        while (length-- > 0) {
            sb.append(this.str);
        }
        this.str = sb.toString();
    }

    @Override
    public String toString() {
        return str;
    }
}
