public class Number {

    private final int value;

    public Number(int value) {
        this.value = validate(value);
    }

    private int validate(int number) {
        if (number < 0) {
            return 0;
        }
        return number;
    }

    public int get() {
        return value;
    }

}
