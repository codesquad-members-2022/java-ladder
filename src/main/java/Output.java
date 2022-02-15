public class Output {

    private static StringBuilder sb = new StringBuilder();

    public static void printUserCountNoti() {
        System.out.println("참여할 사람은 몇 명인가요?");
    }

    public static void printLadderCountNoti() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printLadderGame(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            appendString(arr[i]);
        }
        System.out.println(sb);
    }

    private static void appendString(String[] arr) {
        for (int j = 0; j < arr.length; j++) {
            sb.append(arr[j]);
        }
        sb.append("\n");
    }
}
