import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import view.PrintView;

public class LadderGame {

    private static final String HEIGHT = "|";
    private static final String WIDTH = "-----";
    private static final String VOID = "     ";
    private static final int MAX_RANDOM_NUMBER = 10;

    private final List<String> peoples;
    private final int peopleCount;
    private final int ladderHeight;
    private final ArrayList<ArrayList<String>> ladder;
    private boolean forwardVoid = true;

    public LadderGame(String peopleList, int ladderHeight) {
        peoples = splitPeopleList(peopleList);
        peopleCount = peoples.size();
        this.ladderHeight = ladderHeight;
        ladder = new ArrayList<>();
        initLadderList(ladderHeight);
    }

    private List<String> splitPeopleList(String peopleList) {
        return Stream.of(peopleList.split(","))
            .collect(Collectors.toList());
    }

    private void initLadderList(int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new ArrayList<>());
        }
        initBoard();
    }

    private void initBoard() {
        ArrayList<String> width;
        for (int i = 0; i < ladderHeight; i++) {
            width = ladder.get(i);
            width.add(voidMaker());
            width.add(HEIGHT);
        }
        makeRandomLadder();
    }

    private String voidMaker() {
        int firstPeopleNameLength = peoples.get(0).length();
        return voidBuilder(firstPeopleNameLength);
    }

    private String voidBuilder(int i) {
        StringBuilder sb = new StringBuilder();
        if (i >= 3) {
            return sb.append(" ".repeat(2)).toString();
        }
        return sb.append(" ".repeat(Math.max(0, i - 1))).toString();
    }

    private void makeRandomLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            makeRow(i);
        }
    }

    private void makeRow(int height) {
        ArrayList<String> width = ladder.get(height);
        for (int i = 0; i < peopleCount - 1; i++) {
            putRandomLine(width);
            width.add(HEIGHT);
        }
    }

    private void putRandomLine(ArrayList<String> width) {
        if (isPutLine() && forwardVoid) {
            width.add(WIDTH);
            forwardVoid = false;
            return;
        }
        forwardVoid = true;
        width.add(VOID);
    }
    
    private boolean isPutLine() {
        return makeRandomValue() > (MAX_RANDOM_NUMBER / 2);
    }

    private int makeRandomValue() {
        return (int)(Math.random() * MAX_RANDOM_NUMBER + 1);
    }

    public void start() {
        PrintView.showLadder(ladder);
    }
}
