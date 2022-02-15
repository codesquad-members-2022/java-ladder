package view.input;

public class ValidatorImpl implements Validator {

    private final int VALID_ENTRY_MIN = 2;
    private final int VALID_ENTRY_MAX = 12;

    private final int VALID_HEIGHT_MIN = 1;
    private final int VALID_HEIGHT_MAX = 12;

    private static final ValidatorImpl instance = new ValidatorImpl();

    private ValidatorImpl() {}

    public static ValidatorImpl getInstance() {
        return instance;
    }

    @Override
    public void entryValidate(int entry) {
        if (!(VALID_ENTRY_MIN <= entry && entry < VALID_ENTRY_MAX)) {
            throw new IllegalArgumentException(
                    String.format("참가자 수의 유효범위는 %d 이상 %d 이하입니다.",
                            VALID_ENTRY_MIN,
                            VALID_ENTRY_MAX));
        }
    }

    @Override
    public void heightValidate(int height) {
        if (!(VALID_HEIGHT_MIN <= height && height < VALID_HEIGHT_MAX)) {
            throw new IllegalArgumentException(
                    String.format("높이의 유효범위는 %d 이상 %d 이하입니다.",
                            VALID_HEIGHT_MIN,
                            VALID_HEIGHT_MAX));
        }
    }
}
