public class Number {

    private final int value;

    public Number(int value) {
        this.value = validate(value);
    }

    private int validate(int value) {
        if (value < 0) {
            return 0;
        }
        return value;
    }

    public int get() {
        return value;
    }

}
