package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void createPositionTest(){
        Position position = new Position(3, 4);
        assertThat(position).isEqualTo(new Position(3, 4));
    }

    @ParameterizedTest
    @CsvSource({"0,-1","-1,0","-1,-1"})
    void invalidRangeTest(int x, int y){
        assertThatThrownBy(() -> new Position(x, y)).isInstanceOf(IllegalArgumentException.class);
    }
}
