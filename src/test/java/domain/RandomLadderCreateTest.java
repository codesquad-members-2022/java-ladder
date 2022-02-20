package domain;

import domain.ladder.RandomLadder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomLadderCreateTest {

    @ParameterizedTest
    @CsvSource({"4,5,4", "3,5,3"})
    void createLineTest(int height, int numOfPerson, int expected){
        RandomLadder randomLadder = new RandomLadder(height, numOfPerson);
        assertThat(randomLadder.getHeight()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1,0", "1,-1", "0,1", "-1,1"})
    void invalidInputTest(int height, int numOfPerson){
        assertThatThrownBy(() -> new RandomLadder(height, numOfPerson)).isInstanceOf(IllegalArgumentException.class);
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
