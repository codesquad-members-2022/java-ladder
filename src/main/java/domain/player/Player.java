package domain.player;

class Player {

    public static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Player(String name) throws IllegalStateException {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNameWithPadding() {
        return String.format("%-5s", name);
    }

    private void validateName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("플레이어의 이름을 입력해주세요.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("플레이어 이름의 최대 길이는 " + MAX_NAME_LENGTH + "입니다.");
        }
    }
}
