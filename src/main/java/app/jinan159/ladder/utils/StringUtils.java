package app.jinan159.ladder.utils;

import java.util.stream.IntStream;

public class StringUtils {

    private final static String ALERT_SMALL_TOTAL_SIZE = "문자열의 길이보다 작은 크기로 패딩 문자열을 생성할 수 없습니다.";
    private final static String ALERT_POSITIVE_REQUIRED = "0보다 큰 숫자를 입력하셔야 합니다.";

    public static String padLeftRight(String source, int totalSize) {
        if (source == null ||  totalSize < source.length()) throw new IllegalArgumentException(ALERT_SMALL_TOTAL_SIZE);
        if (source.length() == totalSize) return source;

        return getLeftRightPaddedSource(source, totalSize);
    }

    public static String repeatCharacter(char chr, int count) {
        if (count < 1) throw new IllegalArgumentException(ALERT_POSITIVE_REQUIRED);

        StringBuilder sb = new StringBuilder();
        IntStream.range(0,count)
                .forEach(i -> sb.append(chr));

        return sb.toString();
    }

    private static String getLeftRightPaddedSource(String source, int totalSize) {
        int paddingSize = totalSize - source.length();
        int padSizeA = paddingSize / 2;
        int padSizeB = paddingSize - padSizeA;

        if (padSizeA > padSizeB) {
            return getPadding(padSizeA) + source + getPadding(padSizeB);
        }

        return getPadding(padSizeB) + source + getPadding(padSizeA);
    }

    private static String getPadding(int count) {
        return " ".repeat(count);
    }

}
