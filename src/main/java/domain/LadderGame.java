package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import view.PrintView;

public class LadderGame {

    private final List<String> peoples;
    private final List<LadderRow> ladderRows;
    private final int ladderHeight;

    public LadderGame(String peopleList, int ladderHeight, List<LadderRow> ladderRows) {
        peoples = splitPeopleList(peopleList);
        this.ladderHeight = ladderHeight;
        this.ladderRows = ladderRows;
        init();
    }

    private List<String> splitPeopleList(String peopleList) {
        return Stream.of(peopleList.split(","))
            .collect(Collectors.toList());
    }

    private void init() {
        for (int i = 0; i < ladderHeight; i++) {
            ladderRows.add(new LadderRow(new ArrayList<>(), peoples.size()));
        }
    }

    public void start() {
        PrintView.showLadder(peoples, ladderRows);
    }
}
