package util;

public class StringUtils {
    public static String rpad(int pad, String player) {
        return String.format("%-" + pad + "s", player);
    }
}
