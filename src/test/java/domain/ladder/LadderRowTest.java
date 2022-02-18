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

    @Test
    @DisplayName("짝수 Column ->  세로선을 그릴 수 있음이 보장되는지 테스트")
    void is_VerticalLine_DrawableColumn_Test_O() {
        //given
        int numberOfUsers = 5;
        int evenNumberColumn = 2;

        //when
        LadderRow ladderRow = new LadderRow(numberOfUsers);

        //then
        boolean actualResult = ladderRow.isVerticalLineDrawableColumn(evenNumberColumn);
        assertThat(actualResult)
                .as("짝수 Column에는 세로선을 그릴 수 있으므로 True가 반환되어야 함.")
                .isTrue();
    }

    @Test
    @DisplayName("홀수 Column ->  세로선을 그릴 수 없음이 보장되는지 테스트")
    void is_VerticalLine_DrawableColumn_Test_X() {
        //given
        int numberOfUsers = 5;
        int oddNumberColumn = 3;

        //when
        LadderRow ladderRow = new LadderRow(numberOfUsers);

        //then
        boolean actualResult = ladderRow.isVerticalLineDrawableColumn(oddNumberColumn);
        assertThat(actualResult)
                .as("홀수 Column에는 세로선을 그릴 수 없으므로 False가 반환되어야 함.")
                .isFalse();
    }
}