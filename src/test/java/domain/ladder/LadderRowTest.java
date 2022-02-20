package domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.ladder.LadderElement.*;
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

    @Test
    @DisplayName("짝수 Column -> 가로선을 그릴 수 없음이 보장되는 지 테스트")
    void is_HorizontalLine_DrawableColumn_Test_X_When_EvenColumn() {
        //given
        int numberOfUsers = 2;
        int evenNumberColumn = 2;

        //when
        LadderRow ladderRow = new LadderRow(numberOfUsers);

        //then
        boolean actualResult = ladderRow.isHorizontalLineDrawableColumn(evenNumberColumn);
        assertThat(actualResult)
                .as("짝수 Column에는 가로선을 그릴 수 없으므로 False가 반환되어야 함.")
                .isFalse();
    }

    @Test
    @DisplayName("첫번째 홀수 Column -> 가로선을 그릴 수 있음이 보장되는 지 테스트")
    void is_HorizontalLine_DrawableColumn_Test_O_When_First_OddColumn() {
        //given
        int numberOfUsers = 2;
        int firstOddNumberColumn = 1;

        //when
        LadderRow ladderRow = new LadderRow(numberOfUsers);

        //then
        boolean actualResult = ladderRow.isHorizontalLineDrawableColumn(firstOddNumberColumn);
        assertThat(actualResult)
                .as("첫번째 홀수 Column에는 가로선을 그릴 수 있으므로 True가 반환되어야 함.")
                .isTrue();
    }

    @Test
    @DisplayName("이전의 홀수Column에 EmptyLine이 있을 때만 -> 다음 홀수 Column에 가로선을 둘 수 있음")
    void is_HorizontalLine_DrawableColumn_Test_O_When_BEFORE_OddColumn_Is_Empty_Line() {
        //given
        int numberOfUsers = 2;
        int beforeOddNumberColumn = 1;
        int afterOddNumberColumn = beforeOddNumberColumn + 2;

        //when
        LadderRow ladderRow = new LadderRow(numberOfUsers);
        LadderElement beforeElement = ladderRow.getLadderElement(beforeOddNumberColumn);

        //then
        boolean actualResult = ladderRow.isHorizontalLineDrawableColumn(afterOddNumberColumn);
        boolean expectedResult = (beforeElement == EMPTY_LINE);

        assertThat(actualResult)
                .as("이전의 홀수Column에 EmptyLine이 있을 때만 -> 다음 홀수 Column에 가로선을 둘 수 있음")
                .isEqualTo(expectedResult);
    }
}