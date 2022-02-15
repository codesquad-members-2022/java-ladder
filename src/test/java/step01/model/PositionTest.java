package step01.model;

import org.junit.jupiter.api.Test;
import step01.model.Position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @Test
    void createPositionTest(){
        Position position = new Position(3, 4);
        assertThat(position).isEqualTo(new Position(3, 4));
    }

    @Test
    void invalidRangeTest(){
        assertThatThrownBy(() -> new Position(0, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Position(-1, 0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Position(-1, -1)).isInstanceOf(IllegalArgumentException.class);
    }
}
