package LadderGame;

public class Output {

    private static StringBuilder sb = new StringBuilder();

    public static void printUserCountNotification() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void printLadderCountNotification() {
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
