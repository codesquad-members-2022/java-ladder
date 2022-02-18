package ladder;

public class Validation {

    private static final int MAX_LENGTH = 5;
    public static String playerNameLengthValidation(String player) {

        if (player.length() <= MAX_LENGTH) {
            return playerNamePadding(player);
        }
        return rename(player);
    }

    private static String rename(String player) {
        return player.substring(0, MAX_LENGTH) + " ";
    }

    private static String playerNamePadding(String player) {
        if (player.length() == MAX_LENGTH) {
            return player;
        }

        if (player.length() / 2 == 0) {
            return String.format("%5s", player);
        }
        return String.format("%-5s", player);
    }
}
