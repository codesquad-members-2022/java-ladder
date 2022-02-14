package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    @DisplayName("board 객체 생성(사람수,사다리높이)")
    void create() {
        Board ladder = new Board(3, 5);
        assertEquals(ladder.countPlayers(), 3);
        assertEquals(ladder.getLadderHeight(), 5);
    }

    @Test
    @DisplayName("board 객체 생성시 사람 수는 2명 이상")
    void validPlayerTest() {
        assertThrows(IllegalArgumentException.class, () -> new Board(1, 4));
        assertThrows(IllegalArgumentException.class, () -> new Board(0, 4));
    }

}