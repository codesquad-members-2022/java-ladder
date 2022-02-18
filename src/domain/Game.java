package domain;

import java.util.List;

public class Game {
    private List<Line> ladder;
    private List<String> players;
    private List<String> results;
    private String player;
    private int nowPlayerIndex;
    private int result;

    public Game(Ladder ladder){
        this.ladder = ladder.getLadderInfo();
        this.players = ladder.getPlayersInfo();
        this.results = ladder.getResultsInfo();
    }

    public String play(String player){
        //TODO
        //result 처리하는 로직 들어가야함.
        this.player = player;
        if (player.equals("춘식이")) {
            return "춘식이";
        }
        nowPlayerIndex = findPlayerIndex(player);
        if(nowPlayerIndex==-1){
            return "찾는 플레이어가 없습니다.";
        }
        result = stepDown();
        return results.get(result);
    }

    private int findPlayerIndex(String player) {
        for (int i = 0; i < players.size(); i++) {
            if(checkSamePlayer(i, player)){
                return i;
            }
        }
        return -1;
    }

    private boolean checkSamePlayer(int index, String player) {
        return players.get(index).equals(player);
    }

    private int stepDown(){
        for (int i = 0; i < ladder.size(); i++) {
            System.out.print("now: "+nowPlayerIndex);
            rowCheck(nowPlayerIndex, i);
            System.out.println(" => next: "+nowPlayerIndex);
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
        while(i > 0 && isLine(i, step)){
            i--;
        }
        return (i!=playerIndex); // 수정해야함
    }

    private boolean rightSideCheck(int playerIndex, int step){
        int i = playerIndex+1;
        while(i <= ladder.get(step).size() && isLine(i, step)){
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
