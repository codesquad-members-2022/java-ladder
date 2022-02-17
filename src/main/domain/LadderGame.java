package main.domain;

import static main.view.InputView.QUERY_ALL;

import java.util.List;
import java.util.stream.Collectors;
import main.util.InputUtil;

public class LadderGame {

    private final List<Player> players;
    private final List<String> outcomes;
    private final int numLadder;
    private final LadderPlane plane;

    public LadderGame(List<Player> players, List<String> outcomes, int numLadder) {
        this.players = players;
        this.numLadder = numLadder;
        this.outcomes = outcomes;

        plane = new LadderPlane(getHeight(), getWidth());
    }

    private int getHeight() {
        return numLadder;
    }

    private int getWidth() {
        return 2 * players.size() - 1;
    }

    public String wrapEntry(String name) {
        int gap = LadderElement.getGap();

        int margin = getMargin(name, gap);
        char[] wrap = InputUtil.fillNull(gap);

        for (int ind = 0; ind < name.length(); ind++) {
            wrap[ind + margin] = name.charAt(ind);
        }
        return new String(wrap);
    }

    private int getMargin(String name, int gap) {
        int margin = gap / 2 - name.length() / 2;

        if (margin < 0) {
            throw new IllegalArgumentException();
        }
        return margin;
    }

    public void movePlayers() {
        for (Player player : players) {
            plane.move(player);
            player.receive(outcomes);
        }
    }

    public List<Player> queryPlayers(String query) {
        if (query.equals(QUERY_ALL))
            return players;

        return players.stream()
            .filter(p -> p.getName().equals(query))
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendPlayer(sb);
        appendOutcome(sb);
        return sb.toString();
    }

    private void appendPlayer(StringBuilder sb) {
        for (Player player : players) {
            sb.append(wrapEntry(player.getName())).append(' ');
        }
        sb.append("\n").append(plane);
    }

    private void appendOutcome(StringBuilder sb) {
        for (String outcome : outcomes) {
            sb.append(wrapEntry(outcome)).append(' ');
        }
        sb.append("\n");
    }
}
