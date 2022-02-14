public class Output {
    private final Ladder ladder;

    public Output(Ladder ladder) {
        this.ladder = ladder;
    }

    public void printLadder(char[][] resultLadder) {
        for (char[] line : resultLadder) {
            for (char lineOfch : line) {
                System.out.print(lineOfch);
            }
            System.out.println();
        }
    }
}
