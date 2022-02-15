package ladder.model;

import ladder.utils.RandomGenerator;

public class Board {

    private final int height;
    private final Width width;
    private static final int ZERO = 0;
    private static final int EVEN_NUMBER = 2;

    private static final String COLUMN = "|";
    private static final String BLANK = " ";
    private static final String LADDER = "-";

    private String[][] board;

    public Board(int height, int width) {
        this.height = height;
        this.width = getWidth(width);
        this.board = createBoard();
    }

    public String[][] getBoard(){
        return this.board;
    }

    private Width getWidth(int width) {
        return new Width(width);
    }

    private String[][] createBoard() {
        int height = this.height;
        int width = this.width.getValue();
        String[][] board = new String[height][width];

        for (int row = 0; row < height; row++) {
            fillBoard(board, row);
        }
        return board;
    }

    private void fillBoard(String[][] board, int height) {
        int width = this.width.getValue();

        for (int column = 0; column < width; column++) {
            board[height][column] = getSymbol(board, height, column);
        }
    }

    private String getSymbol(String[][] board, int height, int column) {
        if (isEvenNumber(column)) {
            return board[height][column] = COLUMN;
        }
        if (isEvenNumber(RandomGenerator.getValue())) {
            return board[height][column] = LADDER;
        }
        return board[height][column] = BLANK;
    }

    private boolean isEvenNumber(int column) {
        return column % EVEN_NUMBER == ZERO;
    }

    public static void main(String[] args) {
        Board board = new Board(5, 3);
        String[][] b = board.createBoard();
        for (int row = 0; row < 5; row++) {
            System.out.println();
            for (int col = 0; col < 5; col++) {
                System.out.print(b[row][col]);
            }
        }

    }
}
