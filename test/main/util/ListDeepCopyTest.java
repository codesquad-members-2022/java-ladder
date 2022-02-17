package main.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import main.domain.HorizontalLine;
import org.junit.jupiter.api.Test;

class ListDeepCopyTest {
    @Test
    void 이차원_배열_깊은복사_테스트_1() {
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
    void 이차원_배열_깊은복사_테스트_2() {
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