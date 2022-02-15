public class OutputView {
    private OutputView() {
        throw new IllegalStateException("Utility class");
    }

    public static void printMessage(String str) {
        System.out.println(str);
    }

    public static void print(int[][] lines) {
        StringBuilder sb = new StringBuilder();
        for (int row_i = 0; row_i < lines.length; row_i++) {
            appendLine(sb, lines, row_i);
        }
        System.out.println(sb);
    }

    private static void appendLine(StringBuilder sb, int[][] lines, int row_i) {
        for (int col_i = 0; col_i < lines[0].length - 1; col_i++) {
            appendRadder(sb, lines, row_i, col_i);
        }
        sb.append("|\n");
    }

    private static void appendRadder(StringBuilder sb, int[][] lines, int row_i, int col_i) {
        if (isRadder(col_i, lines[row_i])) {
            sb.append("|-");
            return;
        }
        sb.append("| ");
    }

    private static boolean isRadder(int col_i, int[] lines) {
        return lines[col_i] == 1 && lines[col_i + 1] == 1;
    }
}
