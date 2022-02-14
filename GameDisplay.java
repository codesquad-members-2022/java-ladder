public class GameDisplay {

    public static void showGuideToPersonCount() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public static void showGuideToLadderHeight() {
        System.out.println("최대 사다리 높이는 몇개 인가요?");
    }

    public static void showLadderInfo(String[][] ladderInfo) {
        System.out.println();
        for (int i = 0; i < ladderInfo.length; i++) {
            for (int j = 0; j < ladderInfo[0].length; j++) {
                System.out.printf("%s", ladderInfo[i][j]);
            }
            System.out.println();
        }
    }

}
