package app.jinan159;

import app.jinan159.ladder.LadderGame;

import java.io.IOException;

public class Application {

    private static final int NAME_LENGTH = 5;

    public static void main(String[] args) {
        try {
            LadderGame game = LadderGame.createWithNameLength(NAME_LENGTH);
            game.startGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
