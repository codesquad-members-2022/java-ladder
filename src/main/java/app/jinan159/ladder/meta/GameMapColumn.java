package app.jinan159.ladder.meta;

public class GameMapColumn {

    private final LadderElement element;

    public GameMapColumn(LadderElement element) {
        this.element = element;
    }

    public LadderElement getElement() {
        return element;
    }

    public String getColumnValue() {
        return element.getMark();
    }
}
