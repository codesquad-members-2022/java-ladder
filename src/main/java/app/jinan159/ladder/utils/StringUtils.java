package app.jinan159.ladder.utils;

import java.util.stream.IntStream;

public class StringUtils {

    public static String padLeftRight(String source, int totalSize) {
        if (source.length() == totalSize) return source;

        int paddingSize = totalSize - source.length();
        int padSizeA = paddingSize / 2;
        int padSizeB = paddingSize - padSizeA;

        return getLeftRightPaddedSource(source, padSizeA, padSizeB);
    }

    public static String repeatCharacter(char chr, int count) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0,count)
                .forEach(i -> sb.append(chr));

        return sb.toString();
    }

    private static String getLeftRightPaddedSource(String source, int padSizeA, int padSizeB) {
        if (padSizeA > padSizeB) {
            return getPadding(padSizeA) + source + getPadding(padSizeB);
        }

        return getPadding(padSizeB) + source + getPadding(padSizeA);
    }

    private static String getPadding(int count) {
        return " ".repeat(count);
    }

}
