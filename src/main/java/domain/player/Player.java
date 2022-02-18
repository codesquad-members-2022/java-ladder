package domain.player;

class Player {

    public static final int MAX_SHOWN_NAME_LENGTH = 5;

    private String name;

    public Player(String name) throws IllegalStateException {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getShownName() {
        if (MAX_SHOWN_NAME_LENGTH < name.length()) {
            return name.substring(0, 3) + "..";
        }
        return String.format("%-5s", name);
    }

    private void validateName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("플레이어의 이름을 입력해주세요.");
        }
    }
}
