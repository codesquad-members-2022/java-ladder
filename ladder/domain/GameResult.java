package ladder.domain;

import ladder.view.GameDisplay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    private static final String TOTAL_RESULT_WORD = "all";
    private static final String NOT_FOUND_WORD = "해당되는 사람이 없습니다.";

    private Map<String, String> gameResult;
    private List<String> players;
    private List<Line> ladderInfo;
    private List<String> results;

    private int posX;
    private int posY;
    private int lengthX;
    private int lengthY;

    GameResult(List<String> players, List<Line> ladderInfo, List<String> results) {
        gameResult = new HashMap<>();
        this.players = players;
        this.ladderInfo = ladderInfo;
        this.results = results;

        // posX : 가로축, posY : 세로축
        lengthX = ladderInfo.get(0).getPoints().size();
        lengthY = ladderInfo.size();

        createResult();
    }

    private void createResult() {
        for (int i = 0; i < players.size(); i++) {
            processResult(i);
        }
    }

    private void processResult(int index) {
        posX = index;
        posY = 0;
        while (posY < lengthY) {
            movePoint();
        }
        gameResult.put(players.get(index), results.get(posX));
    }

    private void movePoint() {
        if (posX != 0 && ladderInfo.get(posY).getPoints().get(posX - 1) == true) posX -= 1;
        else if (posX != lengthX && ladderInfo.get(posY).getPoints().get(posX) == true) posX += 1;
        posY++;
    }

    public void getResult(String playerName) {
        if (playerName.equals(TOTAL_RESULT_WORD)) {
            GameDisplay.showTotalResult(gameResult);
            return;
        }
        GameDisplay.showResult(gameResult.getOrDefault(playerName, NOT_FOUND_WORD));
    }
}
