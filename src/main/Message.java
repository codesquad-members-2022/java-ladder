package main;

public enum Message {

    INPUT_NUM_PERSON("참여할 사람은 몇 명인가요?"),
    INPUT_NUM_LADDER("최대 사다리 높이는 몇 개인가요?");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
