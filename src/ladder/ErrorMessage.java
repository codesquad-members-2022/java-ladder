package src.ladder;

public enum ErrorMessage {

    NUMBER_FORMAT_EXCCEPTION("숫자만 입력해주세요.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println(message);
    }
}
