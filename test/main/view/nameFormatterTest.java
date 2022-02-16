package main.view;

import static org.junit.jupiter.api.Assertions.*;

import main.util.nameFormatter;
import org.junit.jupiter.api.Test;

class nameFormatterTest {
    @Test
    public void blankPaddingTest() {
        //given
        String name = "r";
        //when
        String paddedName = nameFormatter.blankPadding(name);
        //then
        assertEquals(paddedName,"  r  ");
    }
}