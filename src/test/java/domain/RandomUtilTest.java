package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomUtilTest {

    @ParameterizedTest
    @DisplayName("이전에 발판이 없어야 하며, 랜덤 boolean이 true일 경우에만 true가 반환, 즉 발판이 생성된다.")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    void put_Line_o(int idx) {

        RandomUtil.putLine(true);
        // TODO
    }

}