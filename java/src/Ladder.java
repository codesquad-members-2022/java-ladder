public class Ladder {

    private char[][] frame;

    public Ladder(int people, int ladderHight) {
        makeAStart(people, ladderHight);
    }

    private int randomNumber() {
        return (int) (Math.random() * 2);
    }

    private char line(int people, int number) {
        char[] line = {'-', ' '};
        if (number < people - 1) {
            return line[randomNumber()];
        }
        return ' ';
    }

    private char[] makeOneHight(int people) {
        char[] ladderLine = new char[people * 2];
        char pole = '|';
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
