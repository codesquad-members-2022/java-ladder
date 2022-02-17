package main.view;

import static org.junit.jupiter.api.Assertions.*;

import main.util.NameFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameFormatterTest {
    @Test
    @DisplayName("1글자 이름 테스트")
    void 사용자_이름_출력_테스트1() {
        //given
        String name = "r";

        //when
        String paddedName = NameFormatter.blankPadding(name);

        //then
        assertEquals("  r  ", paddedName);
    }
    @Test
    @DisplayName("2글자 이름 테스트")
    void 사용자_이름_출력_테스트2() {
        //given
        String name = "rr";

        //when
        String paddedName = NameFormatter.blankPadding(name);

        //then
        assertEquals(" rr  ", paddedName);
    }
    @Test
    @DisplayName("3글자 이름 테스트")
    void 사용자_이름_출력_테스트3() {
        //given
        String name = "rrr";

        //when
        String paddedName = NameFormatter.blankPadding(name);

        //then
        assertEquals(" rrr ", paddedName);
    }
    @Test
    @DisplayName("4글자 이름 테스트")
    void 사용자_이름_출력_테스트4() {
        //given
        String name = "rrrr";

        //when
        String paddedName = NameFormatter.blankPadding(name);

        //then
        assertEquals("rrrr ", paddedName);
    }
    @Test
    @DisplayName("5글자 이름 테스트")
    void 사용자_이름_출력_테스트5() {
        //given
        String name = "rrrrr";

        //when
        String paddedName = NameFormatter.blankPadding(name);

        //then
        assertEquals("rrrrr", paddedName);
    }

}