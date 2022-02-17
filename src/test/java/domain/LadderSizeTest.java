package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderSizeTest {

    @Test
    void createLadderSize(){
        LadderSize ladderSize = LadderSize.create(3, 4);
    }

    @Test
    void psition값을_2차원좌표로_변환(){
        LadderSize ladderSize = LadderSize.create(4, 5);
        int[] position = ladderSize.convertPositionToXY(8);
        Assertions.assertThat(position[0]).isEqualTo(1);
        Assertions.assertThat(position[1]).isEqualTo(3);
    }

    @Test
    void makePositionTest(){
        LadderSize ladderSize = LadderSize.create(4, 5);
        assertThat(ladderSize.getCountOfLine(0.3)).isEqualTo(6);

        LadderSize ladderSize2 = LadderSize.create(1, 5);
        assertThat(ladderSize2.getCountOfLine(0.3)).isEqualTo(1);
    }

    @Test
    @DisplayName("총 인원수의 배수 구하기")
    void multipleNumberOfPerson(){
        LadderSize ladderSize = LadderSize.create(3, 4);
        assertThat(ladderSize.isMultipleOfPersonNum(8)).isTrue();
        assertThat(ladderSize.isMultipleOfPersonNum(9)).isFalse();
    }
}
