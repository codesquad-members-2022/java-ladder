package src.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<LadderRow> ladderRows = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    public Ladder(List<String> playerNames, int ladderHeight) {
        init(playerNames, ladderHeight);
    }

    private void init(List<String> playerNames, int ladderHeight) {
        setPlayers(playerNames);
        createLadder(players.size(), ladderHeight);
    }

    private void setPlayers(List<String> playerNames) {
        for (int i = 0; i < playerNames.size(); i++) {
            players.add(new Player(playerNames.get(i), i));
        }
    }

    private void createLadder(int playerCount, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            ladderRows.add(new LadderRow(playerCount));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringPlayerNames(sb);
        toStringLadder(sb);
        return sb.toString();
    }
    private void toStringPlayerNames(StringBuilder sb) {
        for (int i = 0; i < players.size(); i++) {
            sb.append(String.format("%-6s", players.get(i).getName()));
        }
        sb.append(LadderMaterial.NEW_LINE);
    }
    private void toStringLadder(StringBuilder sb) {
        for (int i = 0; i < ladderRows.size(); i++) {
            appendSingleRow(ladderRows.get(i), sb);
        }
    }
    private void appendSingleRow(LadderRow ladderRow, StringBuilder sb) {
        List<String> ladderRowComponents = ladderRow.getLadderComponents();
        for (int i = 0; i < ladderRowComponents.size(); i++) {
            sb.append(ladderRowComponents.get(i));
        }
        sb.append(LadderMaterial.NEW_LINE);
    }

}

