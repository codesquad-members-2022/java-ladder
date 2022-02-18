package LadderGame;

import java.util.List;

public class Output {

    private static final StringBuilder sb = new StringBuilder();
    private static final String USER_LINE_PADDING = "  ";

    public static void printLadderGame(List<List<String>> arr) {
        printUserList(Client.getUserList());

        for (int row = 0; row < arr.size(); row++) {
            appendString(arr.get(row));
        }
        System.out.println(sb);
    }

    private static void printUserList(List<String> userList) {
        sb.append(USER_LINE_PADDING);

        for (String user : userList) {
            sb.append(userNameLengthValidation(user));
        }
        sb.append("\n");
    }

    private static String userNameLengthValidation(String user) {

        if (user.length() <= 5) {
            return userNamePadding(user);
        }
        return rename(user);
    }

    private static String rename(String user) {
        return user.substring(0, 5) + " ";
    }

    private static String userNamePadding(String user) {
        if (user.length() == 5) {
            return user;
        }

        if (user.length() / 2 == 0) {
            return String.format("%5s", user);
        }
        return String.format("%-5s", user);
    }

    private static void appendString(List<String> arr) {
        for (int col = 0; col < arr.size(); col++) {
            sb.append(arr.get(col));
        }
        sb.append("\n");
    }
}
