import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final String STEP = "-----";
    private static final String BLANK = "     ";
    private static final String POLE = "|";
    private static final List<String> widthLine = List.of(STEP, BLANK);

    private List<List<String>> frame;
    private boolean randomLineKey = true;

    public Ladder(int people, int ladderHight) {
        makeAStart(people, ladderHight);
    }

    private int randomNumber() {
        return (int) (Math.random() * 2);
    }

    private String makeRandomWidthLine() {
        String randomLine = widthLine.get(randomNumber());
        if(randomLine.equals(STEP)) {
            randomLineKey = false;
            return randomLine;
        }
        return randomLine;
    }

    private String selectWidthLine() {
        if (randomLineKey) {
            return makeRandomWidthLine();
        }
        randomLineKey = true;
        return BLANK;
    }

    private String makeWidthLine(int people, int number) {
        if (number < people - 1) {
            return selectWidthLine();
        }
        return BLANK;
    }

    private List<String> makeOneHight(int people) {
        List<String> ladderLine = new ArrayList<>();
        for (int i = 0; i < people * 2; i = i + 2) {
            ladderLine.add(POLE);
            ladderLine.add(makeWidthLine(people, i / 2));
        }
        return ladderLine;
    }

    private void makeAStart(int people, int ladderHight) {
        frame = new ArrayList<>();
        for (int i = 0; i < ladderHight; i++) {
            frame.add(makeOneHight(people));
        }
    }

    public List<List<String>> getFrame() {
        return frame;
    }

}
