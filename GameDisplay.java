package step3;

import java.util.ArrayList;

public class GameDisplay {

    private static final int paddingValue = 5;

    public static void guideInputPlayerName() {
        System.out.println("참여할 사람의 이름을 입력하세요.");
    }

    public static void showError() {
        System.out.println("잘못된 형식의 데이터를 입력하셨습니다..");
    }

    public static void guideInputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇개 인가요?");
    }

    public static void showLadderInfo(ArrayList<String> players, ArrayList<ArrayList<String>> ladderInfo) {
        System.out.printf("%n  ");
        for (String player : players) {
            System.out.printf(getPaddingString(player) + " ");
        }
        System.out.println();
        for (ArrayList<String> item : ladderInfo) {
            System.out.print("    ");
            item.forEach(System.out::print);
            System.out.println();
        }
    }

    private static String getPaddingString(String player) {
        if (paddingValue <= player.length()) return player;
        // Middle Padding
        StringBuilder sb = new StringBuilder(paddingValue);
        for (int i = 0; i < (paddingValue - player.length()) / 2; i++) {
            sb.append(" ");
        }
        sb.append(player);
        while (sb.length() < paddingValue) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
