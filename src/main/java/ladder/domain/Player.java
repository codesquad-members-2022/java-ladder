package ladder.domain;

public class Player {
    private String name;

    public static Player createPlayerWithName(String name) {
        Player player = new Player();
        player.name = name;
        return player;
    }

    public String getName() {
        return name;
    }
}
