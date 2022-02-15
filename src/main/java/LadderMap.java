import java.util.Arrays;
import java.util.stream.IntStream;

public class LadderMap {
    private char[][] map;

    public LadderMap(int personCount, int ladderHeight) {
        if (personCount < 0 || ladderHeight < 0) {
            throw new IllegalArgumentException("매개변수는 0 이상이어야 합니다.");
        }
        initMap(personCount, ladderHeight);
    }

    private void initMap(int personCount, int ladderHeight) {
        map = new char[ladderHeight][personCount * 2 - 1];
        for (char[] line : map) {
            initLine(line);
        }
    }

    private void initLine(char[] line) {
        Arrays.fill(line, '|');
        IntStream.range(0, line.length)
                .filter(i -> i % 2 == 1)
                .forEach(i -> line[i] = randomCreateLadderOrBlank());
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
