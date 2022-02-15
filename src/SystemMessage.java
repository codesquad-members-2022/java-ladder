public enum SystemMessage {
    UI_INPUT_PLAYER_COUNT(0, "참여할 인원 수를 입력하십시오."),
    UI_INPUT_LADDER_HEIGHT(1, "사다리의 높이를 입력하십시오.");

    private final int id;
    private final String message;

    SystemMessage(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
