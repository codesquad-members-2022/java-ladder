package view;

import domain.ladder.Line;
import domain.item.Item;
import domain.user.User;

import java.util.List;
import java.util.Map;

public class OutputUtil {
    private static final String USER_LINE = "|";
    private static final String CONNECTION_LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String PADDING = " ";

    public static void printUsers(List<User> users) {
        users.forEach(user -> System.out.print(addPadding(user.getName())));
        System.out.println();
    }

    public static void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            System.out.println(PADDING.repeat(2) + printLadderLine(line.getLine()));;
        }
    }

    public static void printItems(List<Item> items) {
        items.forEach(item -> System.out.print(addPadding(item.getName())));
        System.out.println();
    }

    public static void printAllResult(Map<String, String> results) {
        System.out.println("실행 결과");
        for (String user : results.keySet()) {
            System.out.println(user + " : " + results.get(user));
        }
    }

    public static void printSingleResult(String result) {
        System.out.println("실행 결과");
        System.out.println(result);
        System.out.println();
    }

    private static String printLadderLine(List<Integer> line) {
        StringBuilder sb = new StringBuilder();
        for (int i : line) {
            if (i % 2 == 0) {
                sb.append(USER_LINE);
            } else if (i == -1) {
                sb.append(EMPTY_LINE);
            } else {
                sb.append(CONNECTION_LINE);
            }
        }
        return sb.toString();
    }

    private static String addPadding(String user) {
        if (user.length() == 5) {
            return user;
        }
        StringBuilder sb = new StringBuilder();
        int whiteSpace = 5 - user.length();
        int frontSpace = whiteSpace / 2;
        int backSpace = whiteSpace - frontSpace;

        sb.append(PADDING.repeat(frontSpace));
        sb.append(user);
        sb.append(PADDING.repeat(backSpace));

        return sb.toString();
    }
}
