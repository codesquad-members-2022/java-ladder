package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderCreateTest {

    @Test
    void createLineTest(){
        Ladder ladder = new Ladder(4, 5);
        assertThat(ladder.getHeight()).isEqualTo(4);

        Ladder ladder2 = new Ladder(3, 5);
        assertThat(ladder2.getHeight()).isEqualTo(3);
    }

    @Test
    void invalidInputTest(){
        assertThatThrownBy(() -> new Ladder(1, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ladder(1, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ladder(0, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ladder(-1, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("포지션들 출력하기")
    void generatePositionsTest(){
        Ladder ladder = new Ladder(3, 5);
        int[] positions = ladder.makeStartPositions();
        for (int position : positions) {
            System.out.println(position);
        }
    }

    @Test
    void alreadyExistedPosition(){
        int[] startPositions = {2, 3};
        assertThat(Ladder.isExisted(startPositions, 2)).isTrue();
        assertThat(Ladder.isExisted(startPositions, 7)).isFalse();
    }

    @Test
    void alreadyExistedBeforePosition(){
        int[] startPositions = {1, 4};
        assertThat(Ladder.isExisted(startPositions, 2)).isTrue();
        assertThat(Ladder.isExisted(startPositions, 7)).isFalse();
    }

    @Test
    void alreadyExistedAfterPosition(){
        int[] startPositions = {1, 4};
        assertThat(Ladder.isExisted(startPositions, 3)).isTrue();
        assertThat(Ladder.isExisted(startPositions, 7)).isFalse();
    }
}
