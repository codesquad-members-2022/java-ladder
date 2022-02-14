public class Number {
    private final int number;

    public Number(int number) {
        this.number = validateNumber(number);
    }

    private int validateNumber(int number) {
        if (number < 0) {
            return 0;
        }
        return number;
    }

    public int getNumber() {
        return number;
    }

}
