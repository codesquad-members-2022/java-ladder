package domain;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderRowTest {

    LadderRow ladderRow;

    @BeforeEach
    void init() {
        ladderRow = new LadderRow(new ArrayList<>(), 10);
    }

    @Test
    @DisplayName("인원 수 * 2의 사이즈가 반환된다.")
    void get_row_test() {
        List<String> row = ladderRow.getRow();
        Assertions.assertThat(row.size()).isEqualTo(20);
    }
}