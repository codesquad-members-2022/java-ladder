package ladder.model;

public class LadderGame {

    private Board board;

    public LadderGame(Board board) {
        this.board = board;
    }

    public String[][] getResult() {
        return board.getBoard();
    }
    private LadderGame (){};

    private static final LadderGame instance = new LadderGame();

    public static final LadderGame getInstance() {
        if(instance == null){
            return new LadderGame();
        }
        return instance;
    }
}
