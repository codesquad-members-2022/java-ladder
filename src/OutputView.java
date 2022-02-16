public class OutputView {
    public void printWithSpacing(String message) {
        System.out.println();
        System.out.println(message);
    }

    public void printLadder(Ladder ladder) {
        printWithSpacing(ladder.render());
    }
}
