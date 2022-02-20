package ladder.utils;

public class ValidationUtils {

    public static void validCoordinate(int coordinate) {
        if (coordinate < 0) {
            throw new IllegalArgumentException("좌표의 값은 0 이상 이어야 합니다.");
        }
    }

    public static void validLadderHeight(int ladderHeight) {
        if (ladderHeight < 0) {
            throw new IllegalArgumentException("사다리 높이는 0 이상 이어야 합니다.");
        }
    }

    public static void validName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5글자가 넘을 수 없습니다.");
        }
    }
}
