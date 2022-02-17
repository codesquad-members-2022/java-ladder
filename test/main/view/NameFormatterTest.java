package main.view;

import static org.junit.jupiter.api.Assertions.*;

import main.util.NameFormatter;
import org.junit.jupiter.api.Test;

class NameFormatterTest {
    @Test
    void 사용자_이름_패딩_테스트() {
        //given
        String name = "r";
        //when
        String paddedName = NameFormatter.blankPadding(name);
        //then
        assertEquals("  r  ", paddedName);
    }
}