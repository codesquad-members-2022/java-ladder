package main;

public enum Message {

    INPUT_NUM_PERSON("참여할 사람은 몇 명인가요?"),
    INPUT_NUM_LADDER("최대 사다리 높이는 몇 개인가요?"),
    INPUT_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
    OUTPUT_VIEW_RESULT("\n실행결과\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
