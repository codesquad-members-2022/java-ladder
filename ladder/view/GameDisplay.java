package ladder.view;

import ladder.domain.Line;

import java.util.List;

public class GameDisplay {

    private static final int paddingValue = 5;
    private static final String LADDER_LINE = "-----";
    private static final String LADDER_EMPTY_LINE = "     ";
    private static final String LADDER_POLE = "|";

    public static void guidePlayerNameInput() {
        System.out.println("참여할 사람의 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
    }

    public static void showError() {
        System.out.println("잘못된 형식의 데이터를 입력하셨습니다.. 다시 입력해주세요.");
    }

    public static void guideExecutionResultInput() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
    }

    public static void guideLadderHeightInput() {
        System.out.println("최대 사다리 높이는 몇개 인가요?");
    }

    public static void showLadderGameInfo(List<String> players, List<Line> ladderInfo, List<String> results) {
        showSubInfo(players);
        showLadderInfo(ladderInfo);
        showSubInfo(results);
    }

    private static void showSubInfo(List<String> items) {
        System.out.print("  ");
        for (String item : items) {
            System.out.printf(getPaddingString(item) + " ");
        }
        System.out.println();
    }

    private static void showLadderInfo(List<Line> ladderInfo) {
        for (Line line : ladderInfo) {
            System.out.print("    ");
            showLadderRow(line);
            System.out.println();
        }
    }

    private static void showLadderRow(Line line) {
        System.out.print(LADDER_POLE);
        line.getPoints().forEach(e -> System.out.print(e == true ? LADDER_LINE + LADDER_POLE : LADDER_EMPTY_LINE + LADDER_POLE));
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
