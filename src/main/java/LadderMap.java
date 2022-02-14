import java.util.Arrays;

public class LadderMap {
    private char[][] map;
    private int personCount;
    private int ladderHeight;

    public LadderMap(int personCount, int ladderHeight) {
        if (personCount < 0 || ladderHeight < 0) {
            throw new IllegalArgumentException("매개변수는 0 이상이어야 합니다.");
        }
        this.personCount = personCount;
        this.ladderHeight = ladderHeight;
        initMap();
    }

    private void initMap() {
        map = new char[ladderHeight][personCount * 2 - 1];
        for (char[] line : map) {
            for (int i = 0; i < line.length; i++) {
                line[i] = '|';
                if (i % 2 == 1) {
                    line[i] = randomCreateLadderOrBlank();
                }
            }
        }
    }

    private char randomCreateLadderOrBlank() {
        int random = (int) (Math.random() * 2);
        if (random == 1) {
            return '-';
        }
        return ' ';
    }

    public char[][] getMap() {
        return map;
    }
}
