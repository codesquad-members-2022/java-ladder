import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import view.PrintView;

public class LadderGame {

    private static final char HEIGHT = '|';
    private static final char WIDTH = '-';
    private static final char VOID = ' ';
    private static final int MAX_RANDOM_NUMBER = 10;

    private final List<String> peoples;
    private final int peopleCount;
    private final int ladderHeight;
    private final char[][] ladderBoard;

    public LadderGame(String peopleList, int ladderHeight) {
        peoples = splitPeopleList(peopleList);
        peopleCount = peoples.size();
        this.ladderHeight = ladderHeight;
        this.ladderBoard = new char[ladderHeight][peopleCount * 2 - 1];
        initBoard();
    }

    private List<String> splitPeopleList(String peopleList) {
        return Stream.of(peopleList.split(","))
            .collect(Collectors.toList());
    }

    private void initBoard() {
        for (int i = 0; i < ladderHeight; i++) {
            putInitWidth(i);
        }
    }

    private void putInitWidth(int height) {
        for (int j = 0; j < peopleCount * 2 - 1; j += 2) {
            ladderBoard[height][j] = HEIGHT;
        }
    }

    public void start() {
        makeRandomLadder();
        PrintView.showLadder(ladderBoard);
    }

    private void makeRandomLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            makeRow(i);
        }
    }

    private void makeRow(int i) {
        for (int j = 1; j < peopleCount * 2 - 1; j += 2) {
            putRandomLine(i, j);
        }
    }

    private void putRandomLine(int i, int j) {
        if (isPutLine()) {
            ladderBoard[i][j] = WIDTH;
            return;
        }
        ladderBoard[i][j] = VOID;
    }
    
    private boolean isPutLine() {
        return makeRandomValue() > (MAX_RANDOM_NUMBER / 2);
    }

    private int makeRandomValue() {
        return (int)(Math.random() * MAX_RANDOM_NUMBER + 1);
    }
}
