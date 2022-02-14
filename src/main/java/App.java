public class App {
    public static void main(String[] args) {
        OutputUtil.printUserCountQuestion();
        int userCount = InputUtil.getUserCount();

        OutputUtil.printLineHeightQuestion();
        int lineHeight = InputUtil.getLineHeight();

        Ladder ladder = new Ladder(userCount, lineHeight);
        OutputUtil.printLadder(ladder.toString());
    }
}
