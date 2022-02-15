package step01.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    void createTest(){
        List<Position> positions = Arrays.asList(new Position(1, 0), new Position(1, 2));
        Line line = new Line(positions);
        assertThat(line).isEqualTo(new Line(positions));
    }

    @Test
    void invalidInputLineTest(){
        List<Position> positions = Arrays.asList(new Position(1, 0), new Position(1, 1));
        assertThatThrownBy(() -> new Line(positions)).isInstanceOf(IllegalArgumentException.class);

        List<Position> positions2 = Arrays.asList(new Position(1, 0), new Position(2, 3));
        assertThatThrownBy(() -> new Line(positions2)).isInstanceOf(IllegalArgumentException.class);
    }
}
