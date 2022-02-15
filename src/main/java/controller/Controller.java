package controller;

import model.Ladder;

public class Controller {
    private static Controller controller;

    private Controller() {}

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public Ladder getLadder(int height, int width) {
        return new Ladder(height, width);
    }
}
