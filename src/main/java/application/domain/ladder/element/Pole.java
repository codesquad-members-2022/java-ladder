package application.domain.ladder.element;

public class Pole implements Element {
    private final String str = "|";

    @Override
    public String toString() {
        return str;
    }
}
