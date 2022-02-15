package view.output;

import domain.ladder.Ladder;
import domain.ladder.LadderElement;

public class OutputViewImpl implements OutputView {

    private static final OutputViewImpl instance = new OutputViewImpl();

    private OutputViewImpl() {}

    public static OutputView getInstance() {
        return instance;
    }

    @Override
    public void printLadder(Ladder ladder) {
        String ladderString = buildLadderString(ladder);
        System.out.print(ladderString);
    }

    private String buildLadderString(Ladder ladder) {
        LadderElement[][] ladderElements = ladder.getLadderElements();
        StringBuilder sb = new StringBuilder();
        for (int y=0; y<ladder.height(); y++) {
            for (int x=0; x< ladder.width(); x++) {
                char symbol = ladderElements[y][x].getSymbol();
                sb.append(symbol);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
