package application.domain.ladder.element;

public class Line implements Element {
    private String str = "-";

    public Line(int length) {
        StringBuilder sb = new StringBuilder();
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
