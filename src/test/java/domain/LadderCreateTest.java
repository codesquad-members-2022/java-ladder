package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderCreateTest {

    @Test
    void createLineTest(){
        Ladder ladder = new Ladder(LadderSize.create(4, 5));
        assertThat(ladder.getHeight()).isEqualTo(4);

        Ladder ladder2 = new Ladder(LadderSize.create(4, 5));
        assertThat(ladder2.getHeight()).isEqualTo(4);
    }

    @Test
    void invalidInputTest(){
        assertThatThrownBy(() -> new Ladder(LadderSize.create(1, 0))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ladder(LadderSize.create(1, -1))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ladder(LadderSize.create(0, 1))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ladder(LadderSize.create(-1, 1))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generatePositionsTest(){
        Ladder ladder = new Ladder(LadderSize.create(3, 4));
        int[] positions = ladder.makeStartPositions();
        for (int position : positions) {
            System.out.println(position);
        }
    }
}
