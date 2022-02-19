package ladder.view;

import ladder.domain.Line;

import java.util.List;

public class GameDisplay {

    private static final int paddingValue = 5;

    public static void guideInputPlayerName() {
        System.out.println("참여할 사람의 이름을 입력하세요.");
    }

    public static void showError() {
        System.out.println("잘못된 형식의 데이터를 입력하셨습니다.. 다시 입력해주세요.");
    }

    public static void guideInputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇개 인가요?");
    }

    public static void showLadderGameInfo(List<String> players, List<Line> ladderInfo) {
        System.out.printf("%n  ");
        for (String player : players) {
            System.out.printf(getPaddingString(player) + " ");
        }
        System.out.println();
        for (Line line : ladderInfo) {
            System.out.print("    ");
            showLadderRow(line);
            System.out.println();
        }
    }

    public static void showLadderRow(Line line) {
        System.out.print("|");
        line.getPoints().forEach(e -> System.out.print(e == true ? "-----" + "|" : "     " + "|"));
    }

    // Middle Padding
    private static String getPaddingString(String player) {
        if (paddingValue <= player.length()) return player;
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
