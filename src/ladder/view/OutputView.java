package ladder.view;

public class OutputView {
    public void print(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            System.out.println();
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col]);
            }
        }
    }
}
