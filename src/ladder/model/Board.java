package ladder.model;

import ladder.utils.RandomGenerator;

public class Board {

    private final int height;
    private final Width width;
    private static final String COLUMN = "|";
    private static final String BLANK = " ";
    private static final String LADDER = "-";

    private String[][] board;

    public Board(int height, int width) {
        this.height = height;
        this.width = getWidth(width);
        this.board = getBoard(height, width);
    }

    private Width getWidth(int width) {
        return new Width(width);
    }

    private String[][] getBoard(int width, int height) {
        return createBoard(this.width, height);
    }

    private String[][] createBoard(Width width, int height) {
        String[][] board = new String[width.getValue()][height];
        for (int row = 0; row < width.getValue(); row++) {
            for (int col = 0; col < height; col++) {
                board[row][col] = getSymbol(board, row, col);
            }
        }
        return board;
    }

    private String getSymbol(String[][] board, int row, int col) {
        if (col % 2 == 0) {
            return board[row][col] = "|";
        }
        if (RandomGenerator.getValue() % 2 == 0) {
            return board[row][col] = "-";
        }
        return board[row][col] = " ";
    }

    public static void main(String[] args) {
        Board board = new Board(7, 5);
        String[][] bo = board.getBoard(5, 7);
        for (int row = 0; row < 7; row++) {
            System.out.println();
            for (int col = 0; col < 5; col++) {
                System.out.print(bo[row][col]);
            }
        }
    }
}
