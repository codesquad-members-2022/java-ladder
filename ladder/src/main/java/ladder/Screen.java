package ladder;

public class Screen {

    public void printUserCountBar() {
        System.out.println(PrintString.USER_COUNT);
    }

    public void printLadderMaxHighBar() {
        System.out.println(PrintString.LADDER_MAX_HIGH);
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