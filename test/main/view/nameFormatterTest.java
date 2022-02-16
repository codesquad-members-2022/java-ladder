package main.view;

import static org.junit.jupiter.api.Assertions.*;

import main.util.nameFormatter;
import org.junit.jupiter.api.Test;

class nameFormatterTest {
    @Test
    void 사용자_이름_패딩_테스트() {
        //given
        String name = "r";
        //when
        String paddedName = nameFormatter.blankPadding(name);
        //then
        assertEquals("  r  ", paddedName);
    }
}