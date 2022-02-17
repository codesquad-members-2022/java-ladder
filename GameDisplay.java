package step2;

import java.util.Arrays;

public class GameDisplay {

    public static void showGuideToPlayerCnt() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public static void showGuideToLadderHeight() {
        System.out.println("최대 사다리 높이는 몇개 인가요?");
    }

    public static void showLadderInfo(String[][] ladderInfo) {
        System.out.println();
        for (String[] item : ladderInfo) {
            Arrays.stream(item).forEach(System.out::print);
            System.out.println();
        }
    }

}
