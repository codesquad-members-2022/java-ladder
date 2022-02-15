public enum Message {
    NUBER_OF_PEOPLE("참여할 사람은 몇 명인가요?"),
    DEPTH_OF_LADDER("최대 사다리 높이는 몇 개인가요?");

    private String message;

    private Message(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
