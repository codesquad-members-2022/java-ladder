package ladder;

public class Screen {

    private static final String USER_COUNT = "참여할 사람은 몇 명인가요?";
    private static final String LADDER_MAX_HIGH = "최대 사다리 높이는 몇 개인가요?";

    public void printUserCountBar() {
        System.out.println(USER_COUNT);
    }

    public void printLadderMaxHighBar() {
        System.out.println(LADDER_MAX_HIGH);
    }

    public void printLadder(String[][] ladder) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (String[] strings : ladder) {
            for (String string : strings) {
                sb.append(string);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
