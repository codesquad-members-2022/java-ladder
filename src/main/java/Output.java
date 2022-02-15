public class Output {

    public static void userCountNoti() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public static void ladderCountNoti() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printLadderGame(String[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
