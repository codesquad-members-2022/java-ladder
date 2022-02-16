public class StringUtils {
    public static String center(String str, int length, char padChar) {
        int strSize = str.length();
        if (strSize > length)
            return str.substring(0, length - 2) + "..";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (length - strSize) / 2; i++)
            sb.append(padChar);
        sb.append(str);
        while (sb.length() < length)
            sb.append(padChar);
        return sb.toString();
    }
}
