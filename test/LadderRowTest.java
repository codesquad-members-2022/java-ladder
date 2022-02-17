import domain.LadderRow;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderRowTest {

    @Test
    void When_n개의라인_Expect_n개의라인을갖는사다리가로열() {
        LadderRow oneLineladderRow = new LadderRow(1);
        assertEquals(oneLineladderRow.getRow().chars()
                .filter(line -> line == '|')
                .count(), 1);

        LadderRow twoLineladderRow = new LadderRow(2);
        assertEquals(twoLineladderRow.getRow().chars()
                .filter(line -> line == '|')
                .count(), 2);

        LadderRow threeLineladderRow = new LadderRow(3);
        assertEquals(threeLineladderRow.getRow().chars()
                .filter(line -> line == '|')
                .count(), 3);

        LadderRow fourLineladderRow = new LadderRow(4);
        assertEquals(fourLineladderRow.getRow().chars()
                .filter(line -> line == '|')
                .count(), 4);

        LadderRow fiveLineladderRow = new LadderRow(5);
        assertEquals(fiveLineladderRow.getRow().chars()
                .filter(line -> line == '|')
                .count(), 5);
    }
}
