package ladder;

import java.util.Arrays;

public class Output {

    private static final String USER_COUNT = "참여할 사람은 몇 명인가요?";
    private static final String LADDER_MAX_HIGH = "최대 사다리 높이는 몇 개인가요?";

    public int printUserCountBar(Input input) {
        System.out.println(USER_COUNT);
        return input.inputString();
    }

    public int printLadderMaxHighBar(Input input) {
        System.out.println(LADDER_MAX_HIGH);
        return input.inputString();
    }

    public void printLadder(String[][] ladder) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (String[] strings : ladder) {
            Arrays.stream(strings).forEach(sb::append);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
