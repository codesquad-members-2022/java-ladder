import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {

    private static final List<String> widthLine = Arrays.asList("-----", "     ");
    private static final String pole = "|";

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
        if(randomLine.equals("-----")) {
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
        return "     ";
    }

    private String makeWidthLine(int people, int number) {
        if (number < people - 1) {
            return selectWidthLine();
        }
        return "     ";
    }

    private List<String> makeOneHight(int people) {
        List<String> ladderLine = new ArrayList<>();
        for (int i = 0; i < people * 2; i = i + 2) {
            ladderLine.add(pole);
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
