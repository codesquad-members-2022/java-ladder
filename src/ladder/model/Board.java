package ladder.model;

import ladder.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int height;
    private final Width width;

    private static final String COLUMN = "|";
    private static final String BLANK = " ";
    private static final String LADDER = "-";

    private List<String> board;

    public Board(int width, int height) {
        this.width = getWidth(width);
        this.height = height;
        this.board = createBoard();
    }

    private Width getWidth(int width) {
        return new Width(width);
    }

    private List<String> createBoard() {
        List<String> elementList = new ArrayList<>();
        int totalCount = this.width.getValue() * this.height;

        for (int row = 0; row < totalCount; row += this.width.getValue()) {
            inputElementsTo(elementList, row);
        }
        return elementList;
    }

    private void inputElementsTo(List<String> elementList, int index) {
        for (int col = index; col < index + this.width.getValue(); col++) {
            getSymbol(elementList, col % (this.width.getValue()));
        }
    }

    private void getSymbol(List<String> elementList, int value) {
        if (isColumn(value)) {
            elementList.add(COLUMN);
            return;
        }
        if (isLadder(RandomGenerator.getValue())) {
            elementList.add(LADDER);
            return;
        }
        elementList.add(BLANK);
    }

    private boolean isColumn(int value) {
        return plusable(value) && isEvenNumber(value);
    }

    private boolean plusable(int value) {
        return value < this.width.getValue();
    }

    private boolean isEvenNumber(int col) {
        return col % 2 == 0;
    }

    /**
     * 중복 코드이지만 가독성을 위해
     * 한 번 더 사용하는 것이 옳은지?
     * */
    private boolean isLadder(int value) {
        return value % 2 == 0;
    }

    public static void main(String[] args) throws Exception {
        Board board = new Board(5, 7);

        List<String> createBoard = board.createBoard();

        for (int index = 0; index < createBoard.size(); index += board.width.getValue()) {
            System.out.println();
            for (int col = index; col < index + board.width.getValue(); col++) {
                System.out.print(createBoard.get(col));
            }
        }
    }
}