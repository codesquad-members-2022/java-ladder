public class Number {

    private static final String VALUE_ERROR_MESSAGE = "값을 잘못입력하셨습니다.";
    private final int value;

    public Number(String value) {
        this.value = validate(value);
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println(VALUE_ERROR_MESSAGE);
            return -1;
        }
    }

    private int validate(String value) {
        int parseIntValue = parseInt(value);
        if (parseIntValue < 0) {
            return 0;
        }
        return parseIntValue;
    }

    public int get() {
        return value;
    }

}
