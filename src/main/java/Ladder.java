public class Ladder {

    private static final String PILLAR = "|";
    private static final String LINE = "-";

    private final String[][] ladder;

    private boolean isPillar(int col) {
        return col % 2 == 0;
    }

    public Ladder(int entry, int height) {
        int width = entry + (entry - 1);
        this.ladder = new String[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (isPillar(col)) {
                    ladder[row][col] = PILLAR;
                } else {
                    // TODO: 랜덤으로 연결하기
                    ladder[row][col] = LINE;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String[] row : ladder) {
            for (String col : row) {
                sb.append(col);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
