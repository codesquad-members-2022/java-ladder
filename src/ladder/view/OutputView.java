package ladder.view;

public class OutputView {

    private static final StringBuilder sb = new StringBuilder();

    public void print(String[][] board) {
        sb.setLength(0);
        for (String[] strings : board) {
            sb.append("\n");
            add(strings, board[0].length);
        }
        System.out.println(sb);
    }

    private void add(String[] strings, int length) {
        for (int col = 0; col < length; col++) {
            sb.append(strings[col]);
        }
    }
}
