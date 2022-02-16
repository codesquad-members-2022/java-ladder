public class Application {

  public static void main(String[] args) {
    LadderGame game = new LadderGame();
    game.printLadder(game.makeLadder(game.gameInfo()));
  }
}
