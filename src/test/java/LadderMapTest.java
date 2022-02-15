import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class LadderMapTest {

    @Test
    @DisplayName("personCount 또는 ladderHeight는 0 이상이어야 한다.")
    void argumentIsNegativeThrowException() {
        assertThrows(IllegalArgumentException.class, () -> new LadderMap(-1, -1));
    }

    @Test
    void initMap() {
        LadderMap ladderMap = new LadderMap(3, 5);

        char[][] map = ladderMap.getCloneMap();
        for (char[] line : map) {
            for (int i = 0; i < line.length; i++) {
                if (i % 2 == 1) {
                    assertTrue(line[i] == ' ' || line[i] == '-');
                } else {
                    assertTrue(line[i] == '|');
                }
            }
        }
    }

    @Test
    void cloneMap() throws NoSuchFieldException, IllegalAccessException {
        LadderMap ladderMap = new LadderMap(5, 5);

        Field field = ladderMap.getClass().getDeclaredField("map");
        field.setAccessible(true);

        char[][] map = (char[][]) field.get(ladderMap);
        char[][] cloneMap = ladderMap.getCloneMap();

        assertNotEquals(map, cloneMap);
    }
}