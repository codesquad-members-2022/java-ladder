package ladder.util;

public class StringUtils {

    private StringUtils() { throw new IllegalStateException("Utility class"); }

    public static String center(String str, int length, char padChar) {
        int strSize = str.length();
        if (isStrSizeGreaterThanLength(length, strSize))
            return str;

        return createCenterString(str, length, padChar, strSize);
    }

    private static boolean isStrSizeGreaterThanLength(int length, int strSize) {
        return strSize > length;
    }

    private static String createCenterString(String str, int length, char padChar, int strSize) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(padChar).repeat((length - strSize) / 2));
        sb.append(str);
        sb.append(String.valueOf(padChar).repeat(length - sb.length()));
        return sb.toString();
    }


    public static String withLimitLength(String str, int limit) {
        if (str.length() <= limit) {
            return str;
        }
        return str.substring(0, limit - 2) + "..";
    }
}
