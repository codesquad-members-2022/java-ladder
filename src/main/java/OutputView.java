import java.util.List;

public class OutputView {
    private OutputView() {
        throw new IllegalStateException("Utility class");
    }

    public static void printMessage(String str) {
        System.out.println(str);
    }

    public static void print(List<Line> lines) {
        StringBuilder sb = new StringBuilder();

        for (Line line : lines) {
            appendLine(sb, line);
        }

        System.out.println(sb);
    }

    private static void appendLine(StringBuilder sb, Line line) {
        int playCount = line.getMaxLength();
        sb.append("     ");
        for (int i = 0; i < playCount - 1; i++) {
            appendRadder(sb, line, i);
        }
        sb.append("|\n");
    }

    private static void appendRadder(StringBuilder sb, Line line, int radderPos) {
        if (line.isRadder(radderPos)) {
            sb.append("|-----");
            return;
        }
        sb.append("|     ");
    }
}
