package domain;

import java.util.Map;

public class GamePlayResults {
    private final Map<String, String> gamePlayResults;
    private static final String TERMINATE = "춘식이";

    public GamePlayResults(Map<String, String> gamePlayResults){
        this.gamePlayResults = gamePlayResults;
    }

    public String get(String player) {
        if (player.equals(TERMINATE)) {
            return TERMINATE;
        }

        if(player.equals("all")){
            return getAllResults();
        }

        if (gamePlayResults.containsKey(player)){
            return gamePlayResults.get(player);
        }
        return "찾는 플레이어가 없습니다.";
    }

    private String getAllResults() {
        StringBuilder sb = new StringBuilder();
        for(String player: gamePlayResults.keySet()){
            sb.append(player);
            sb.append(": ");
            sb.append(gamePlayResults.get(player));
            sb.append("\n");
        }
        return sb.toString();
    }


}
