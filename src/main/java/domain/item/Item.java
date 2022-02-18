package domain.item;


public class Item {
    private final String name;

    private Item(String name) {
        this.name = name;
    }

    public static Item createResult(String name) {
        return new Item(name);
    }

    public String getName() {
        return name;
    }
}
