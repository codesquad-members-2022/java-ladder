public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        new Client();
        LadderGame ladderGame = new LadderGame();
        ladderGame.build();
    }
}
