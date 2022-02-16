package main.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ListDeepCopyTest {
    @Test
    void 이차원_배열_깊은복사_테스트() {
        //given
        List<List<String>> orig = new ArrayList<>();
        orig.add(Arrays.asList("a", "b", "c"));
        orig.add(Arrays.asList("d", "e", "f"));

        // when
        List<List<String>> cloned = ListDeepCopy.string2dDeepCopy(orig);
        cloned.get(0).set(0,"A");

        //then
        assertEquals("a", orig.get(0).get(0));
        assertNotEquals(cloned.get(0).get(0),orig.get(0).get(0));
    }
}