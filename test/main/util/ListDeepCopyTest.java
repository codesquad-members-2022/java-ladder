package main.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import main.domain.HorizontalLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListDeepCopyTest {
    @Test
    @DisplayName("복사한 값이 기존의 값과 동일한지 테스트")
    void 사다리_배열_깊은복사_테스트_1() {
        //given
        List<HorizontalLine> orig = new ArrayList<>();
        orig.add(new HorizontalLine(3));
        orig.get(0).setPoints(Arrays.asList(true,true,true));

        // when
        List<HorizontalLine> cloned = ListDeepCopy.boardDeepCopy(orig);

        //then
        assertEquals(Arrays.asList(true,true,true), cloned.get(0).getPoints().get(0));
    }

    @Test
    @DisplayName("복사한 값을 변경할때, 기존의 값이 변경되지 않는지 테스트")
    void 사다리_배열_깊은복사_테스트_2() {
        //given
        List<HorizontalLine> orig = new ArrayList<>();
        orig.add(new HorizontalLine(3));
        orig.get(0).setPoints(Arrays.asList(true,true,true));

        // when
        List<HorizontalLine> cloned = ListDeepCopy.boardDeepCopy(orig);
        cloned.get(0).setPoints(Arrays.asList(false,false,false));

        //then
        assertEquals(Arrays.asList(true,true,true), orig.get(0).getPoints());
    }
}