public class Ladder {

    private static final char[] widthLine = {'-', ' '};
    private static final char pole = '|';

    private char[][] frame;

    public Ladder(int people, int ladderHight) {
        makeAStart(people, ladderHight);
    }

    private int randomNumber() {
        return (int) (Math.random() * 2);
    }

    private char line(int people, int number) {
        if (number < people - 1) {
            return widthLine[randomNumber()];
        }
        return ' ';
    }

    private char[] makeOneHight(int people) {
        char[] ladderLine = new char[people * 2];
        for (int i = 0; i < people * 2; i = i + 2) {
            ladderLine[i] = pole;
            ladderLine[i + 1] = line(people, i / 2);
        }
        return ladderLine;
    }

    private void makeAStart(int people, int ladderHight) {
        frame = new char[ladderHight][people * 2];
        for (int i = 0; i < ladderHight; i++) {
            frame[i] = makeOneHight(people);
        }
    }

    public char[][] getLadder() {
        return frame;
    }

}
