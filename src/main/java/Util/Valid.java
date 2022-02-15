package Util;

public class Valid {

    private static final int MIN_PLAYER = 2;
    private static final String PLAYER_ERROR_MESSAGE = "사람 수는 2명 이상이어야 합니다.";

    public static void checkPlayers(int count) {
        if(count < MIN_PLAYER) {
            throw new IllegalArgumentException(PLAYER_ERROR_MESSAGE);
        }
    }
}
