class Player {

    public static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Player(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("플레이어 이름의 최대 길이는 " + MAX_NAME_LENGTH + "입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
