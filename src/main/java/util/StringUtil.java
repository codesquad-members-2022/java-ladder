package util;

public class StringUtil {
    public static String rpad(int pad, String player) {
        return String.format("%-" + pad + "s", player);
    }
}
