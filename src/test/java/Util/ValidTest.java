package Util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidTest {


    @Test
    void input_regex_test() {

        String input2 = "honux,crong,jk,ivy";
        assertEquals(Validation.checkInputNames(input2),input2);
        //쉼표가 아닐 때
        String input1 = "honux;crong;jk;ivy";
        assertThrows(IllegalArgumentException.class, () -> Validation.checkInputNames(input1));
        // 1명
        String input3 = "honux";
        assertThrows(IllegalArgumentException.class, () -> Validation.checkInputNames(input3));
        // 공백이 포함될때
        String input4 = "honux, crong, jk, ivy";
        assertThrows(IllegalArgumentException.class, () -> Validation.checkInputNames(input4));
        // 10명 초과
        String input5 = "honux,crong,jk,ivy,jay,tany,pio,jun,rouis,ttatj,ron2";
        assertThrows(IllegalArgumentException.class, () -> Validation.checkInputNames(input5));
        //10명
        String input6 = "honux,crong,jk,ivy,jay,tany,pio,jun,rouis,ttatj";
        assertEquals(Validation.checkInputNames(input6),input6);
        // 5글자 초과
        String input7 = "tattjw,tattjwi,cmsskkk,cmsskkkkkkkkkk";
        assertThrows(IllegalArgumentException.class, () -> Validation.checkInputNames(input7));

    }
}