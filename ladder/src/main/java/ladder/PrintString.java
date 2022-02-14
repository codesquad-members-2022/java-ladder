package ladder;

public enum PrintString {
    USER_COUNT("참여할 사람은 몇 명인가요?"),
    LADDER_MAX_HIGH("최대 사다리 높이는 몇 개인가요?");

    private final String value;

    PrintString(String printString) {
        this.value = printString;
    }

    @Override
    public String toString() {
        return value;
    }
}