package ladder.model;

import ladder.utils.RandomGenerator;

public class Board {

    private final int height;
    private final Width width;

    private static final String COLUMN = "|";
    private static final String BLANK = " ";
    private static final String LADDER = "-";

    private String[][] board;

    public Board(int width, int height) {
        this.width = getWidth(width);
        this.height = height;
        this.board = createBoard(width);
    }

    private Width getWidth(int width) {
        return new Width(width);
    }

    public String[][] getBoard() {
        return createBoard(this.height);
    }

    private String[][] createBoard(int height) {
        String[][] board = new String[height][width.getValue()];
        for (int row = 0; row < height; row++) {
            fillBoard(board, row);
        }
        return board;
    }

    private void fillBoard(String[][] board, int row) {
        for (int col = 0; col < width.getValue(); col++) {
            board[row][col] = getSymbol(board, row, col);
        }
    }

    private String getSymbol(String[][] board, int row, int col) {
        if (col % 2 == 0) {
            return board[row][col] = COLUMN;
        }
        if (RandomGenerator.getValue() % 2 == 0) {
            return board[row][col] = LADDER;
        }
        return board[row][col] = BLANK;
    }
}

