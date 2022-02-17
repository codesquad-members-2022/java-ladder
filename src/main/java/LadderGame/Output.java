package LadderGame;

import java.util.List;

public class Output {

    private static StringBuilder sb = new StringBuilder();

    public static void printUserCountNotification() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void printLadderCountNotification() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

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
