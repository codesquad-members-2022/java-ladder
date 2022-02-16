package ladder.system;

public enum SystemMessage {

    INPUT_COUNT_AND_HEIGHT("높이와 사람 숫자를 입력해주세요");

    private final String description;

    SystemMessage(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description + "[사다리 높이 -> Enter -> 사람 숫자]";
    }
}
