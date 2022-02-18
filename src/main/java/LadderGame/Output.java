package LadderGame;

import java.util.List;

public class Output {

    private static final StringBuilder sb = new StringBuilder();
    private static final String USER_LINE_PADDING = "  ";

    public static void printLadderGame(List<Line> ladder) {
        printUserList(Client.getUserList());

        for (int row = 0; row < ladder.size(); row++) {
            appendString(ladder.get(row));
        }
        System.out.println(sb);
    }

    private static void printUserList(List<String> userList) {
        sb.append(USER_LINE_PADDING);

        for (String user : userList) {
            sb.append(Validation.playerNameLengthValidation(user));
        }
        sb.append("\n");
    }

    private static void appendString(Line line) {
        List<String> copyLine = line.getLine();

        for (int col = 0; col < copyLine.size(); col++) {
            sb.append(copyLine.get(col));
        }
        sb.append("\n");
    }
}
