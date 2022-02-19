package domain;

public class Formatter {
    public static String checkAndPadding(String player, int width) {
        if (player.length() >= width) {
            return skipPadding(player, width);
        }
        return addPadding(player, width);
    }

    private static String skipPadding(String player, int width) {
        if(player.length()==width){
            return player;
        }
        return player.substring(0, 3)+"..";
    }

    private static String addPadding(String player, int width) {
        StringBuilder sb = new StringBuilder();
        int centerOfLetters = (width/2)+1;
        if (player.length() <= centerOfLetters) {
            sb.append(addLeftPadding(player, centerOfLetters));
        }
        sb.append(player);
        sb.append(addRightPadding(sb.toString(), width));

        return sb.toString();
    }

    private static String addLeftPadding(String player, int centerOfLetters) {
        if (player.length() < centerOfLetters) {
            return "  ";
        }
        return " ";
    }

    private static String addRightPadding(String player, int width) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width - player.length(); i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
