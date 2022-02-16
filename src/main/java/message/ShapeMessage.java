package message;

public class ShapeMessage {
    public static String getRowIndexErrMsg(int height) {
        return String.format("인덱스 범위를 초과했습니다. (최대 row %d)", height - 1);
    }

    public static String getColIndexErrMsg(int row, int width) {
        return String.format("인덱스 범위를 초과했습니다. (" + row + " 번 째 열의 최대 col %d)", width - 1);
    }
}
