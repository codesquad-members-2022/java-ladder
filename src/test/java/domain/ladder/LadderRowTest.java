package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderRowTest {

    @Test
    @DisplayName("인원수에 대해 정확한 가로 길이가 보장되는 지에 대한 테스트")
    void LadderWidthTest() {
        //given
        int numberOfUsers = 5;

        //when
        LadderRow ladderRow = new LadderRow(numberOfUsers);

        //then
        int actualWidth = ladderRow.width();
        int expectWidth = 2 * numberOfUsers - 1;

        assertThat(actualWidth)
                .as("LadderRow의 가로 길이는, 2* 인원수 - 1 이어야한다.")
                .isEqualTo(expectWidth);
    }
}