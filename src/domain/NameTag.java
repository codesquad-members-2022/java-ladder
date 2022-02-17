package domain;

import view.InputManager;

public class NameTag extends ShapeInitializer{
    public static final int LEFT_PADDING_SIZE = 1;
    public static final int RIGHT_PADDING_SIZE = 1;
    public static final int NAME_TAG_SIZE = InputManager.LIMIT_NAME_LENGTH + LEFT_PADDING_SIZE + RIGHT_PADDING_SIZE;

    private String nameTag;

    public NameTag(String name) {
        this.nameTag = wrapPlayerName(name);
    }

    private String wrapPlayerName(String name) {
        return init(name, NAME_TAG_SIZE - name.length()); // 지정 된 NAME_TAG_SIZE에서 입력받은 name의 길이만큼 빼서 추가해야 할 padding의 갯수를 구한다.
    }

    private String init(String name, int numberOfPadding) {
        StringBuilder sb = new StringBuilder();
        if (isEven(numberOfPadding)) {
            sb.append(initEmpty(numberOfPadding / 2) + name + initEmpty(numberOfPadding / 2));
            return sb.toString();
        }
        sb.append(initEmpty(numberOfPadding / 2) + name + initEmpty(numberOfPadding / 2 + 1));
        return sb.toString();
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    public String getNameTag() {
        return nameTag;
    }
}
