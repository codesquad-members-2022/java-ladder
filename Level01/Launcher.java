public class Launcher {
    private int player;
    private int height;
    private String[][] result;

    public void run() {
        player = Print.inputPlayer();
        height = Print.inputHeight();
        result = makeLadder(player,height);

        Print.result(result);
    }
}
