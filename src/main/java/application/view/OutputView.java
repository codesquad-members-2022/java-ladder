package application.view;

import application.game.Game;

public class OutputView {
    private static OutputView ov;

    private OutputView() {}

    public static OutputView getInstance() {
        if (ov == null) {
            ov = new OutputView();
        }
        return ov;
    }

    public void printGame(Game game) {
        System.out.println(game);
    }

    public void printErrMsg(String msg) {
        System.out.println(msg);
    }
}
