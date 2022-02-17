package LadderGame;

import java.util.List;

public class Output {

    private static StringBuilder sb = new StringBuilder();

    public static void printLadderGame(List<List<String>> arr) {
        for (int row = 0; row < arr.size(); row++) {
            appendString(arr.get(row));
        }
        System.out.println(sb);
    }

    private static void appendString(List<String> arr) {
        for (int col = 0; col < arr.size(); col++) {
            sb.append(arr.get(col));
        }
        sb.append("\n");
    }
}
