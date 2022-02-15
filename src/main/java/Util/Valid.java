package Util;

public class Valid {

    private static final int MIN_PLAYER = 2;
    private static final int MIN_HEIGHT = 1;
    private static final String PLAYER_ERROR_MESSAGE = "사람 수는 2명 이상이어야 합니다.";
    private static final String HEIGHT_ERROR_MESSGAE = "사다리의 높이는 1이상이어야 합니다.";

    public static void checkPlayers(int count) {
        if(count < MIN_PLAYER) {
            throw new IllegalArgumentException(PLAYER_ERROR_MESSAGE);
        }
    }

    public static void checkHegiht(int height) {
        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkPlayersReturn(int count) {
        if(count < MIN_PLAYER) {
            throw new IllegalArgumentException(PLAYER_ERROR_MESSAGE);
        }
        return count;
    }

    public static int checkHeight(int height) {
        if(height < MIN_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSGAE);
        }
        return height;
    }
}
