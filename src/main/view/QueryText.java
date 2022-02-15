package main.view;

public enum QueryText {
    NUM_OF_ATTENDANTS("참여할 사람은 몇 명인가요?"),
    MAXIMUM_HEIGHT_OF_LADDERS("최대 사다리 높이는 몇 개 인가요?");
    private final String text;

    QueryText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
