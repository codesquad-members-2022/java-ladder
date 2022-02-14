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

}