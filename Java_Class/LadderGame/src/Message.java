public enum Message {
    HEADCOUNT("참여할 사람은 몇 명인가요?"),
    LADDERHEIGHT("최대 사다리 높이는 몇 개인가요?"),
    NOTNUMBER("숫자를 입력해주세요");
    String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
