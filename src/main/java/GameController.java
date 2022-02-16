public class GameController {

    public void run() {
        int userCount = getUserCount();
        int lineHeight = getLineHeight();

        Ladder ladder = new Ladder(userCount, lineHeight);
        OutputUtil.printLadder(ladder.toString());
    }

    private int getUserCount() {
        OutputUtil.printUserCountQuestion();
        return InputUtil.getInput();
    }

    private int getLineHeight() {
        OutputUtil.printLineHeightQuestion();
        return InputUtil.getInput();
    }
}
