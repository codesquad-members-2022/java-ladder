public class Application {
    public static void main(String[] args) {
        LadderGame game = new LadderGame();
        game.makeLadder(game.gameInfo());
        game.printLadder();
    }
}
