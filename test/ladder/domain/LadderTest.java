package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("중복된 결과가 나오지 않는 것을 확인")
    void checkNoDuplicateResult() {
        Ladder ladder = new Ladder(100, 100);
        Set<Integer> resultIndexSet = IntStream.range(0, 100)
                .map(ladder::getRewardIndex)
                .boxed()
                .collect(Collectors.toSet());
        assertEquals(resultIndexSet.size(), 100);
    }
}
