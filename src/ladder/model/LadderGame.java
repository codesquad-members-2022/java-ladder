package ladder.model;

public class LadderGame {

    private Board board;

    public LadderGame(Board board) {
        this.board = board;
    }

    public String[][] getResult(){
        return board.getBoard();
    }
}
