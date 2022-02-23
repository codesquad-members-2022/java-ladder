package application.view;

import application.domain.LadderGame;

public class OutputView {
    private static OutputView ov;

    private OutputView() {}

    public static OutputView getInstance() {
        if (ov == null) {
            ov = new OutputView();
        }
        return ov;
    }

    public void printGame(LadderGame game) {
        System.out.println(game.screen());
    }

    public void printResult(String result) {
        System.out.println(result);
    }
}
