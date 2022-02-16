public class OutputView {
    public void printLayout(Players players, Ladder ladder) {
        System.out.println();
        printPlayers(players);
        printLadder(ladder);
    }

    private void printPlayers(Players players) {
        System.out.println(players);
    }

    private void printLadder(Ladder ladder) {
        System.out.println(ladder.render());
    }
}
