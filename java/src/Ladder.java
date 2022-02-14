public class Ladder {

    private String[][] ladder;

    public Ladder(int people, int ladderHight) {
        ladder = new String[ladderHight][people * 2];
        makeLadder(people, ladderHight);
    }

    private int randomNumber() {
        return (int) (Math.random() * 2);
    }

    private String line(int people, int number) {
        String[] line = {"-", " "};
        if (number < people - 1) {
            return line[randomNumber()];
        }
        return " ";
    }

    private String[] makeOneHight(int people) {
        String[] ladderLine = new String[people * 2];
        String pole = "|";
        for (int i = 0; i < people * 2; i = i + 2) {
            ladderLine[i] = pole;
            ladderLine[i + 1] = line(people, i / 2);
        }
        return ladderLine;
    }

    private void makeLadder(int people, int ladderHight) {
        for (int i = 0; i < ladderHight; i++) {
            ladder[i] = makeOneHight(people);
        }
    }

    public String[][] getLadder() {
        return ladder;
    }

}
