package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FloorTest {

    @Test
    @DisplayName("floor에 연결선 확인")
    void floor_isStep() {
        //의미 있는 테스트인가..?
        Floor floor = new Floor(3, List.of(true,false,false));
        Assertions.assertThat(floor.isSTEP(0)).isTrue();
        Assertions.assertThat(floor.isSTEP(1)).isFalse();
        Assertions.assertThat(floor.isSTEP(2)).isFalse();
        Assertions.assertThatIllegalArgumentException().isThrownBy(()->floor.isSTEP(-1));
        Assertions.assertThatIllegalArgumentException().isThrownBy(()->floor.isSTEP(3));
    }

    @Test
    @DisplayName("canDraw")
    void drawPart() {
        List<Boolean> list = List.of(true);
        Floor floor = new Floor(1,list);
        //canDrow(boolean previousElement)
        Assertions.assertThat(floor.canDraw(false)).isTrue();
        Assertions.assertThat(floor.canDraw(true)).isFalse();
    }
}
