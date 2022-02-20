package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FloorTest {

    @Test
    @DisplayName("floor에 연결선 확인")
    void floor_isStep() {
        Floor floor = new Floor(3, List.of(true,false,false));
        Assertions.assertThat(floor.isSTEP(0)).isTrue();
        Assertions.assertThat(floor.isSTEP(1)).isFalse();
        Assertions.assertThat(floor.isSTEP(1)).isFalse();
    }
}
