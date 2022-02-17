import java.util.List;

public class OutputView {
    private OutputView() {
        throw new IllegalStateException("Utility class");
    }

    public static void printMessage(String str) {
        System.out.println(str);
    }

    public static void print(Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        appendPlayers(sb, ladder.getPlayers());
        appendLines(sb, ladder.getLines());

        System.out.println(sb);
    }

    private static void appendPlayers(StringBuilder sb, List<Player> players) {
        sb.append("   ");
        for (Player player : players) {
            sb.append(String.format("%5s ", StringUtils.center(player.getName(), 5, ' ')));
        }
        sb.append("\n");
    }

    private static void appendLines(StringBuilder sb, List<Line> lines) {
        for (Line line : lines) {
            appendLine(sb, line);
        }
    }

    private static void appendLine(StringBuilder sb, Line line) {
        int playCount = line.getMaxLength();
        sb.append("     ");
        for (int i = 0; i < playCount - 1; i++) {
            appendLadder(sb, line, i);
        }
        sb.append("|\n");
    }

    private static void appendLadder(StringBuilder sb, Line line, int ladderPos) {
        if (line.isLadder(ladderPos)) {
            sb.append("|-----");
            return;
        }
        sb.append("|     ");
    }
}
