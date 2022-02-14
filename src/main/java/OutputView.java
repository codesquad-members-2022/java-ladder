public class OutputView {
    public static void printMessage(String str) {
        System.out.println(str);
    }

    public static void print(int[][] rows) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < rows[0].length - 1; j++) {
                if (rows[i][j] == 1 && rows[i][j + 1] == 1) {
                    sb.append("|-");
                    continue;
                }
                sb.append("| ");
            }
            sb.append("|\n");
        }

        System.out.println(sb.toString());
    }
}
