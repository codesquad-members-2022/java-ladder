package domain;

import domain.ladder.RandomLadder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomLadderCreateTest {

    @Test
    void createLineTest(){
        RandomLadder randomLadder = new RandomLadder(4, 5);
        assertThat(randomLadder.getHeight()).isEqualTo(4);

        RandomLadder randomLadder2 = new RandomLadder(3, 5);
        assertThat(randomLadder2.getHeight()).isEqualTo(3);
    }

    @Test
    void invalidInputTest(){
        assertThatThrownBy(() -> new RandomLadder(1, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RandomLadder(1, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RandomLadder(0, 1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new RandomLadder(-1, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("포지션들 출력하기")
    void generatePositionsTest(){
        RandomLadder randomLadder = new RandomLadder(3, 5);
        int[] positions = randomLadder.makeStartPositions();
        for (int position : positions) {
            System.out.println(position);
        }
    }

    @Test
    void alreadyExistedPosition(){
        int[] startPositions = {2, 3};
        assertThat(RandomLadder.isExisted(startPositions, 2)).isTrue();
        assertThat(RandomLadder.isExisted(startPositions, 7)).isFalse();
    }

    @Test
    void alreadyExistedBeforePosition(){
        int[] startPositions = {1, 4};
        assertThat(RandomLadder.isExisted(startPositions, 2)).isTrue();
        assertThat(RandomLadder.isExisted(startPositions, 7)).isFalse();
    }

    @Test
    void alreadyExistedAfterPosition(){
        int[] startPositions = {1, 4};
        assertThat(RandomLadder.isExisted(startPositions, 3)).isTrue();
        assertThat(RandomLadder.isExisted(startPositions, 7)).isFalse();
    }
}
