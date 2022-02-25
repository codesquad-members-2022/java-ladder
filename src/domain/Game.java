package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<Line> ladder;
    private List<String> players;
    private List<String> results;
    private GamePlayResults gamePlayResults;
    private int nowPlayerIndex;
    private int result;

    public Game(Ladder ladder){
        this.ladder = ladder.getLadderInfo();
        this.players = ladder.getPlayersInfo();
        this.results = ladder.getResultsInfo();
    }

    public String play(String player){
        getAllPlayersResults();
        return gamePlayResults.get(player);
    }

    private void getAllPlayersResults(){
        Map<String, String> gameResults = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            nowPlayerIndex = i;
            gameResults.put(players.get(nowPlayerIndex), getOnePlayerResult());
        }
        gamePlayResults = new GamePlayResults(gameResults);
    }

    private String getOnePlayerResult() {
        result = stepDown();
        return results.get(result);
    }

    private int stepDown(){
        for (int i = 0; i < ladder.size(); i++) {
            rowCheck(nowPlayerIndex, i);
        }
        return nowPlayerIndex;
    }

    private void rowCheck(int playerIndex, int step){
        if(leftSideCheck(playerIndex, step)){
            resetPlayerIndexByLeftSide(playerIndex, step);
            return;
        }
        if(rightSideCheck(playerIndex, step)){
            resetPlayerIndexByRightSide(playerIndex, step);
            return;
        }
    }

    private boolean leftSideCheck(int playerIndex, int step){
        int i = playerIndex;
        while(i > 0 && isLine(i, step)){    // 맨 왼쪽 인덱스를 제외하고, 라인이 있는지 확인
            i--;
        }
        return (i!=playerIndex);
    }

    private boolean rightSideCheck(int playerIndex, int step){
        int i = playerIndex+1;
        while(i <= ladder.get(step).size() && isLine(i, step)){ // 맨 오른쪽 인덱스를 제외하고, 라인이 있는지 확인
            i++;
        }
        return (i!=playerIndex+1);
    }

    private boolean isLine(int index, int step){
        return ladder.get(step).get(index-1);
    }

    private void resetPlayerIndexByLeftSide(int playerIndex, int step){
        int i = playerIndex;
        while(i > 0 && isLine(i, step)){
            i--;
        }
        nowPlayerIndex = i;
    }

    private void resetPlayerIndexByRightSide(int playerIndex, int step){
        int i = playerIndex+1;
        while(i <= ladder.get(step).size() && isLine(i, step)){
            i++;
        }
        nowPlayerIndex = i-1;
    }
}
