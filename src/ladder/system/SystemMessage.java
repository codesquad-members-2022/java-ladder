package ladder.system;

public enum SystemMessage {
    INPUT_COUNT_AND_HEIGHT("사람 숫자와 높이를 입력해주세요");

    private final String description;

    SystemMessage(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SystemMessage{" +
                "description='" + description + '\'' +
                '}';
    }
}
