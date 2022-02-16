public class Output {

    private static final StringBuilder sb = new StringBuilder();

    public static void printLadder(char[][] ladder) {
        for (int i = 0; i < ladder.length; i++) {
            addLadderData(ladder, i);
        }

        System.out.println(sb);
    }

    private static void addLadderData(char[][] ladder, int i) {
        for (int j = 0; j < ladder[i].length; j++) {
            sb.append(ladder[i][j]);
        }

        sb.append("\n");
    }

}
